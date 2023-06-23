package kr.co.tjoeun.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.UserDAO;

@Service
public class UserService {
  
  @Autowired
  private UserDAO userDAO;
  
  // loginUserBean : Server 실행될 때 Session Scope 에 생성한 UserBean 객체 
  @Resource(name="loginUserBean")
  private UserBean loginUserBean;
  
  public boolean checkUserIdExist(String user_id) {	
	String user_name = userDAO.checkUserIdExist(user_id);
	if(user_name == null) {
	  return true;
	}else {
	  return false;
	}	
  }
  
  public void addUserInfo(UserBean joinUserBean) {
	userDAO.addUserInfo(joinUserBean);
  }
  
  public void getLoginUserInfo(UserBean tmpLoginjoinUserBean) {
	  UserBean tmpLoginjoinUserBean2 = userDAO.getLoginUserInfo(tmpLoginjoinUserBean);
	  
	  // 로그인에 성공해서 로그인할 때 입력한 아이디와 비밀번호에 해당하는
	  // (데이터베이스로부터) user_idx 와 user_name 을 가져왔다면 
	  // tmpLoginjoinUserBean2(UserBean) 객체가 null 이 아니고
	  // 이 user_idx 와 user_name 을 
	  // Session Scope 에 생성된 UserBean 객체(loginUserBean)의
	  // 멤버변수 user_idx 와 user_name 에 할당함
	  // ㄴ 이 값들은 사용자가 로그인한 상태에서 계속 유지됨
	  if(tmpLoginjoinUserBean2 != null) {
		  loginUserBean.setUser_idx(tmpLoginjoinUserBean2.getUser_idx());
		  loginUserBean.setUser_name(tmpLoginjoinUserBean2.getUser_name());
		  loginUserBean.setUserLogin(true);
	  }
	  
	  return;
  }
}
