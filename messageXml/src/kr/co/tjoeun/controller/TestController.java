package kr.co.tjoeun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	 // ReloadableResourceBundleMessageSource 객체를 주입받음
	@Autowired
	 ReloadableResourceBundleMessageSource res;
	
	@GetMapping("/test1")
	public String test1() {
		
		String name1 = res.getMessage("student1.name1", null, null);
		String name2 = res.getMessage("student2.name2", null, null);
		
		System.out.printf("student1.name1 : %s\n", name1 );
		System.out.printf("student2.name2 : %s\n", name2 );
		
		return "test1";
	}
}
