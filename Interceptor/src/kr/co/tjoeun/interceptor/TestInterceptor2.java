package kr.co.tjoeun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor2 extends HandlerInterceptorAdapter{
	
	 // Controller 의 메소드가 호출되기 전에 자동으로 호출되는 메소드
	// 이 메소드가 false 를 반환하면 code 의 흐름이 중단됨
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("TestTnterceptor2 - proHandle");
		System.out.println("Controller 의 메소드가 호출되기 전에 자동으로 호출되는 메소드 이 메소드가 false 를 반환하면 code 의 흐름이 중단됨");
		return true;
	}
	
	// Controller 의 메소드의 수행이 완료되고
	// View 처리를 수행하기 전에 자동으로 호출되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TestTnterceptor2 - postHandle");
		System.out.println("Controller 의 메소드의 수행이 완료되고 View 처리를 수행하기 전에 자동으로 호출되는 메소드");
	}
	
	// View 처리까지 완료되고 응답결과(response) 가 
	// Client 의 browser 로 전달되기 전에 자동으로 호출되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TestTnterceptor2 - afterCompletion");
		System.out.println("View 처리까지 완료되고 응답결과(response) 가 Client 의 browser 로 전달되기 전에 자동으로 호출되는 메소드");
	}
	
	
}