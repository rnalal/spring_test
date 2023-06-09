package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.tjoeun.beans.UserInfoBean;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(UserInfoBean bean) {
		
		bean.setUserName("더조은");
		bean.setUserId("spring");
		bean.setUserPw("12343");
		bean.setUserPostcode("10025");
		bean.setUserAddress1("일산시");
		bean.setUserAddress2("정발산역");
		
		return "test1";				
	}
	
	@GetMapping("/test2")
	public String test2(UserInfoBean bean) {
		
		bean.setUserName("더조은");
		bean.setUserId("spring");
		bean.setUserPw("12343");
		bean.setUserPostcode("10025");
		bean.setUserAddress1("일산시");
		bean.setUserAddress2("정발산역");		
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(@ModelAttribute("bean") UserInfoBean bean) {
		
		bean.setUserName("더조은");
		bean.setUserId("spring");
		bean.setUserPw("12343");
		bean.setUserPostcode("10025");
		bean.setUserAddress1("일산시");
		bean.setUserAddress2("정발산역");		
		
		return "test3";
	}

	@GetMapping("/test4")
	public String test4(Model model) {
		
		UserInfoBean bean = new UserInfoBean();
		
		bean.setUserName("더조은");
		bean.setUserId("spring");
		bean.setUserPw("12343");
		bean.setUserPostcode("10025");
		bean.setUserAddress1("일산시");
		bean.setUserAddress2("정발산역");		
		
		model.addAttribute("dataBean", bean);
		
		return "test4";
	}
}










