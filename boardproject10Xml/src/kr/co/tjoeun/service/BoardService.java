package kr.co.tjoeun.service;


import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.BoardDAO;


@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
  
  @Autowired
  private BoardDAO boardDAO;
  
  // Session Scope 에 있는 UserBean 객체 주입받기
  @Resource(name = "loginUserBean")
  @Lazy
  private UserBean loginUserBean;
  
  // 파일 업로드 경로
  @Value("${path.upload}")
  private String pathUpload;
  
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

	MultipartFile uploadFile =  writeContentBean.getUpload_file();
	
	if(uploadFile.getSize() > 0) {	
  	  // 파일 이름
  	  String fileName = saveUploadFile(uploadFile);
  	  System.out.println("fileName : " + fileName);
  	  writeContentBean.setContent_file(fileName);
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
  public List<ContentBean> getContentList(int board_info_idx){
	return boardDAO.getContentList(board_info_idx);	
  } 
  
  // 상세페이지에 출력할 데이터 가져오기
  public ContentBean getContentInfo(int content_idx) {
	return boardDAO.getContentInfo(content_idx);
	
  }
  
} // Service Class

