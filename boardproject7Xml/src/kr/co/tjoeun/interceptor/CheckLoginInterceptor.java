package kr.co.tjoeun.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.tjoeun.bean.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
  
  @Resource(name="loginUserBean")
  @Lazy
  private UserBean loginUserBean;
  
  
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



