package kr.co.tjoeun.service;


import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.PageBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.BoardDAO;


@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
  
  @Autowired
  private BoardDAO boardDAO;
  
  // Session Scope 에 있는 UserBean 객체 주입받기
  @Resource(name = "loginUserBean")
  private UserBean loginUserBean;
  
  // 파일 업로드 경로
  @Value("${path.upload}")
  private String pathUpload;
  
  // paging 관련 변수 : 페이지당 게시글의 개수
  @Value("${page.listcnt}")
  private int pageListcnt;
  
  // paging 관련 변수 : 페이지 버튼 개수
  @Value("${page.paginationcnt}")
  private int pagePaginationcnt;
  
  // 파일을 저장하는 메소드
  private String saveUploadFile(MultipartFile uploadFile) {
	String fileName = System.currentTimeMillis() + "_" + uploadFile.getOriginalFilename();
	
	try {
	  uploadFile.transferTo(new File(pathUpload + "/" + fileName));
	}catch(Exception e) {
	  e.printStackTrace();	  
	}
	return fileName;
  }
 
    
  public void addContentInfo(ContentBean writeContentBean) {
	
	System.out.println(writeContentBean.getContent_subject());
	System.out.println(writeContentBean.getContent_text());
	System.out.println(writeContentBean.getUpload_file().getSize());
	System.out.println(writeContentBean.getUpload_file());
	
	MultipartFile upload_file =  writeContentBean.getUpload_file();
	
	if(upload_file.getSize() > 0) {	
  	  // 파일 이름
  	  String file_name = saveUploadFile(upload_file);
  	  System.out.println("file_name : " + file_name);
  	  writeContentBean.setContent_file(file_name);
	}
	
	// 현재 로그인 상태인 사람이 작성자가 됨
	// 작성자 인덱스번호(content_writer_idx) 에
	// 현재 로그인 상태인 사람(UserBean("loginUserBean"))의 
	// user_idx 를 할당함	
	writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
	
	// Service 에서 DAO(Repository) 에 있는 addContentInfo() 호출하기
	boardDAO.addContentInfo(writeContentBean);
	
	
  } // addContentInfo
  
  //게시판 index 로 게시판 이름 가져오기(조회하기)  <-- SELECT
  public String getBoardInfoName(int board_info_idx) {
	return boardDAO.getBoardInfoName(board_info_idx);
	
  } // getBoardInfoName
  
  // 게시글 리스트 가져오기
  public List<ContentBean> getContentList(int board_info_idx, int page){
	/*
	 page   pagination number
	   1 -> 0 (start)  <- (page - 1) * pageListcnt(10)
	   2 -> 10  
	   3 -> 20  
	*/
	int start = (page - 1) * pageListcnt;
	RowBounds rowBounds = new RowBounds(start, pageListcnt);
	
	return boardDAO.getContentList(board_info_idx, rowBounds);	
  }
  
  // 상세페이지에 출력할 데이터 가져오기
  public ContentBean getContentInfo(int content_idx) {
	return boardDAO.getContentInfo(content_idx);

  }
  
  // 수정 페이지에서 게시글 수정하기
  public void modifyContentInfo(ContentBean modifyContentBean) {
	
	MultipartFile upload_file = modifyContentBean.getUpload_file();
	
	if(upload_file.getSize() > 0) {
	  String file_name = saveUploadFile(upload_file);
	  modifyContentBean.setContent_file(file_name);
	}
	
	boardDAO.modifyContentInfo(modifyContentBean);
  }
  
  // 게시글 삭제하기
  public void deleteContentInfo(int content_idx) {
	boardDAO.deleteContentInfo(content_idx);
  }
  
  // 게시글 전체 개수 가져오기 
  // Controller 로부터 int content_board_idx, int currentPage 값을 받아옴
  // pageListcnt : 페이지당 게시글의 개수
  // pagePaginationcnt : 페이지 버튼 개수
  public PageBean getContentCnt(int content_board_idx, int currentPage) {
	// 게시글 전체 개수
	int contentCnt = boardDAO.getContentCnt(content_board_idx);
                            	  // 생성자의 parameter
                            	  // 전체글 개수, 현재 페이지 번호, 페이지당 글개수, 페이지 버튼 개수
	PageBean pageBean = new PageBean(contentCnt, currentPage, pageListcnt, pagePaginationcnt); 
	
	return pageBean;
  }


  
  
  
} // Service Class




