package kr.co.tjoeun.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.ContentBean;

@Repository
public class BoardDAO {
  
  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;
  
  public void addContentInfo(ContentBean writeContentBean) {
	sqlSessionTemplate.insert("board.addContentInfo", writeContentBean);
  }
  
  //게시판 index 로 게시판 이름 가져오기(조회하기)  <-- SELECT
  public String getBoardInfoName(int board_info_idx) {
	return sqlSessionTemplate.selectOne("board.getBoardInfoName",board_info_idx);
  }
  
  // 게시글 리스트 가져오기
  public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds){
	return sqlSessionTemplate.selectList("board.getContentList",board_info_idx, rowBounds);
  }
  
  //상세페이지에 출력할 데이터 가져오기
  public ContentBean getContentInfo(int content_idx) {
	return sqlSessionTemplate.selectOne("board.getContentInfo", content_idx);
  }
  
  // 수정 페이지에서 게시글 수정하기
  public void modifyContentInfo(ContentBean modifyContentBean) {
	  sqlSessionTemplate.update("board.modifyContentInfo", modifyContentBean);
  }
  
  // 게시글 삭제하기
  public void deleteContentInfo(int content_idx) {
	  sqlSessionTemplate.delete("board.deleteContentInfo", content_idx);
  }
  
  // 게시글 전체 개수 가져오기
  public int getContentCnt(int content_board_idx) {
	 return sqlSessionTemplate.selectOne("board.getContentCnt", content_board_idx);
  }

}


