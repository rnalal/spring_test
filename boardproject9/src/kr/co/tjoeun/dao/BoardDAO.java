package kr.co.tjoeun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.mapper.BoardMapper;

@Repository
public class BoardDAO {
  
  @Autowired
  private BoardMapper boardMapper;
  
  public void addContentInfo(ContentBean writeContentBean) {
	boardMapper.addContentInfo(writeContentBean);
  }
  
  // 게시판 index 로 게시판 이름 가져오기(조회하기)  <-- select
  public String getBoardInfoName(int board_info_idx) {
	  return boardMapper.getBoardInfoName(board_info_idx);
  }
  
  // 게시글 리스트 가져오기
  public List<ContentBean> getContentList(int board_info_idx){
	  return boardMapper.getContentList(board_info_idx);
  }
  
  // 상세페이지에 출력할 데이터 가져오기
  public ContentBean getContentInfo(int content_idx) {
	  return boardMapper.getContentInfo(content_idx);
  }

}
