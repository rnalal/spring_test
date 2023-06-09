package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.BeanData;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(BeanData bean) {		
		bean.setData1("spring framework");
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(BeanData bean) {		
		bean.setData1("spring framework");
		bean.setData2("web application");
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(BeanData bean) {		
		bean.setData1("spring framework");
		bean.setData2("web application");
		bean.setData3("비밀번호");
		return "test3";
	}

	@GetMapping("/test4")
	public String test4(BeanData bean) {		
		bean.setData1("spring framework");
		bean.setData2("web application");
		bean.setData3("비밀번호");
		bean.setData4("안녕하세요. 여기는 더조은 IT 아카데미입니다.");
		return "test4";
	}
}

