package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// 하위 경로 통합하기
@RequestMapping("/sub2")
public class Sub2Controller {
	
	@RequestMapping(value="/test5", method=RequestMethod.GET)
	public String test5() {
		return "sub2/test5";
	}
	@RequestMapping("/test6")
	public String test6() {
		return "sub2/test6";
	}
}
