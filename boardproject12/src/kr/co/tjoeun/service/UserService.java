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
	// tmpLoginjoinUserBean2 (UserBean)객체가 null 이 아니고
	// 이 user_idx 와 user_name 을 
	// Session Scope 에 생성된 UserBean 객체(loginUserBean)의
	// 멤버변수 user_idx 와 user_name 에 할당함
	//  ㄴ 이 값들은 사용자가 로그인한 상태에서 계속 유지됨
	if(tmpLoginjoinUserBean2 != null) {
	  loginUserBean.setUser_idx(tmpLoginjoinUserBean2.getUser_idx());
	  loginUserBean.setUser_name(tmpLoginjoinUserBean2.getUser_name());
	  loginUserBean.setUserLogin(true);
	}	
	
	return;
  }   
 
  
  public void getModifyUserInfo(UserBean modifyUserBean) {
	// tmpModifyUserBean <-- DB 로부터 가져온 user_id, user_name 값을 가지고 있는 UserBean 객체
	UserBean tmpModifyUserBean = userDAO.getModifyUserInfo(loginUserBean.getUser_idx());
	// tmpModifyUserBean  객체가 가지고 있는 user_id, user_name 값을
	// Spring 이 자동 생성해서 parameter 로 전달해 준 modifyUserBean 객체의 
	// 멤버변수 user_id, user_name 에 저장함
	modifyUserBean.setUser_id(tmpModifyUserBean.getUser_id());
	modifyUserBean.setUser_name(tmpModifyUserBean.getUser_name());
	// 현재 로그인한 회원(loginUserBean) 의 index 번호를
	// Spring 이 자동 생성해서 parameter 로 전달해 준 modifyUserBean 객체의 
	// 멤버변수 user_idx 에 저장함
	modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
	
	return;	
  }
  
  public void modifyUserInfo(UserBean modifyUserBean) {
	// Session Scope 에 있는 loginUserBean 의 idx 를
    // Controller 에서 생성한 modifyUserBean 객체의 idx 에 할당함 
	modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
	// 수정할 사용자의 idx 를 Service 의 modifyUserInfo() 메소드로 넘겨줌
	userDAO.modifyUserInfo(modifyUserBean);
  }
  
}
