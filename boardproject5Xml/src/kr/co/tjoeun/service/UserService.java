package kr.co.tjoeun.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.UserDAO;

@Service
public class UserService {
  
  @Autowired
  private UserDAO userDAO;
  
  @Resource(name = "loginUserBean")
  @Lazy
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
	
  public void getLoginUserInfo(UserBean tempLoginUserBean) {
	
	UserBean tempLoginUserBean2 = userDAO.getLoginUserInfo(tempLoginUserBean);
		
	  if(tempLoginUserBean2 != null) {
		loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
		loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
		loginUserBean.setUserLogin(true);
      }
	  
	  return;
  }
  
}
