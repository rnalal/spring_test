package kr.co.tjoeun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.tjoeun.bean.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
  
  // java 방식에서는 interceptor 에서 bean 이 자동 주입이 안 됨
  // ServletAppContext 에서 bean 을 자동 주입 받아서
  // ServletAppContext 에서 CheckLoginInterceptor 의 객체를 생성할 때
  // CheckLoginInterceptor 생성자의 argument 로 넣어줌
  private UserBean loginUserBean;
  
  public CheckLoginInterceptor(UserBean loginUserBean) {
	this.loginUserBean = loginUserBean;
  }
  
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	
	// 로그인이 안 된 상태라면
	if (loginUserBean.isUserLogin() == false) {
	  // ContextPath 를 얻어옴
	  String contextPath = request.getContextPath();
	  response.sendRedirect(contextPath + "/user/not_login");
	  return false;
	}
	// 로그인이 된 상태라면
    return true;
  }

}



