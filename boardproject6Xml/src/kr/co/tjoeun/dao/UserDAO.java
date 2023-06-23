package kr.co.tjoeun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.UserBean;

@Repository
public class UserDAO {

  @Autowired
  private SqlSessionTemplate sqlSessionTemplate;
  
  public String checkUserIdExist(String user_id) {
	String user_name = sqlSessionTemplate.selectOne("user.checkUserIdExist", user_id);
	return user_name;
  }

  public void addUserInfo(UserBean joinUserBean) {
	sqlSessionTemplate.insert("user.addUserInfo", joinUserBean);
  }
  
  public UserBean getLoginUserInfo(UserBean tempLoginUserBean) {
	return sqlSessionTemplate.selectOne("user.getLoginUserInfo", tempLoginUserBean);
  }
}





