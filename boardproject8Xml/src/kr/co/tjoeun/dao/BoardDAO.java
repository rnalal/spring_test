package kr.co.tjoeun.dao;

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

}
