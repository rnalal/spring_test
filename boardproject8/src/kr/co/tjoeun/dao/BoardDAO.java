package kr.co.tjoeun.dao;

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

}
