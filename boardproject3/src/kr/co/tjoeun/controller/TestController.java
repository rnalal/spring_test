package kr.co.tjoeun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.service.TestService;

@Controller
public class TestController {
  
  @Autowired
  TestService testService;
  
  @GetMapping("/test1")
  public String test1(Model model) {	
	String str1 = testService.testServiceMethod();
	model.addAttribute("str1", str1);
	
	return "test1";
  }
}
