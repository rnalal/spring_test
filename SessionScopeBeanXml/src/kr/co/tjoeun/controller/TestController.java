package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBeanByName;
import kr.co.tjoeun.beans.TestBeanByType;

@Controller
public class TestController {
	
	// Bean을 type(클래스 이름) 주입받음
	@Autowired
	TestBeanByType testeanByType;
	
	// Bean을 name(설정한 이름)으로 주입받음
	@Resource(name = "sessionBean2")
	TestBeanByName sessionBean2;
	
	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1() {
		return "result1";
	}
}
