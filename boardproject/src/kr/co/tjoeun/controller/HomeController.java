package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(HttpServletRequest request) {
		String url = request.getContextPath();
		// System.out.println("주소표시줄에 http://localhost:8080/SpringMVCXml/ 이 입력됩니다.");
		// return "/WEB-INF/views/index.jsp";
		return "index";
	}
	

	@RequestMapping(value="/tjoeun", method=RequestMethod.GET)
	public String tjeoun() {
		System.out.println("주소표시줄에 http://localhost:8080/SpringMVCXml/tjoeun 이 입력됩니다.");
		return null;
	}
	
	@RequestMapping(value="/spring", method=RequestMethod.GET)
	public String spring() {
		System.out.println("주소표시줄에 http://localhost:8080/SpringMVCXml/spring 이 입력됩니다.");
		return null;
	}
}
