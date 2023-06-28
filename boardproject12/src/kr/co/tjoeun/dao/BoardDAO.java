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

/* 
 // 페이징 처리 테스트 위해서 대량 게시글 업로드  
  public void addContentInfo(ContentBean writeContentBean) {
	for(int i = 0; i < 564; i++) {
		boardMapper.addContentInfo(writeContentBean);
	}
  }
*/
  
  public void addContentInfo(ContentBean writeContentBean) {
		boardMapper.addContentInfo(writeContentBean);
  }
  
  // 게시판 index 로 게시판 이름 가져오기(조회하기)  <-- select
  public String getBoardInfoName(int board_info_idx) {
	  return boardMapper.getBoardInfoName(board_info_idx);
  }
  
  // 게시글 리스트 가져오기
  public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds){
	  return boardMapper.getContentList(board_info_idx, rowBounds);
  }
  
  // 상세페이지에 출력할 데이터 가져오기
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










