package kr.co.tjoeun.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.mapper.BoardMapper;

@Repository
public class BoardDAO {
  
  @Autowired
  private BoardMapper boardMapper;
  
  public void addContentInfo(ContentBean writeContentBean) {
	  // 이곳에 for문을 사용하면 더미게시글을 올려서 paging 연습을 할 수 있음
	  //for(int i = 0; i < 658; i++) {
	    boardMapper.addContentInfo(writeContentBean);
	  //}
  }
  
  //게시판 index 로 게시판 이름 가져오기(조회하기)  <-- SELECT
  public String getBoardInfoName(int board_info_idx) {
	return boardMapper.getBoardInfoName(board_info_idx);
  }
  
  // 게시글 리스트 가져오기
  public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds){
	return boardMapper.getContentList(board_info_idx, rowBounds);
  }
  
  //상세페이지에 출력할 데이터 가져오기
  public ContentBean getContentInfo(int content_idx) {
	return boardMapper.getContentInfo(content_idx);
  }
  
  // 수정 페이지에서 게시글 수정하기
  public void modifyContentInfo(ContentBean modifyContentBean) {
	boardMapper.modifyContentInfo(modifyContentBean);
  }
  
  // 게시글 삭제하기
  public void deleteContentInfo(int content_idx) {
	boardMapper.deleteContentInfo(content_idx);
  }
  
  // 게시글 전체 개수 가져오기 
  public int getContentCnt(int content_board_idx) {
	return boardMapper.getContentCnt(content_board_idx);
  }

}


