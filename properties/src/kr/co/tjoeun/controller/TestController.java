package kr.co.tjoeun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySources({ @PropertySource("/WEB-INF/properties/data1.properties"),
				   @PropertySource("/WEB-INF/properties/data2.properties")})
/*
	 @PropertySource("/WEB-INF/properties/data1.properties")
	 @PropertySource("/WEB-INF/properties/data2.properties")
 */

/*
	 @PropertySource(value= { 
		 "/WEB-INF/properties/data1.properties",
		 "/WEB-INF/properties/data2.properties" 
	 })
 */

public class TestController {
	
	@Value("${student1.number1}")
	private int number1;
	
	@Value("${student1.name1}")
	private String name1;
	
	@Value("${student2.number2}")
	private int number2;
	
	@Value("${student2.name2}")
	private String name2;	
	
	@Value("${student3.number3}")
	private int number3;
	
	@Value("${student3.name3}")
	private String name3;
	
	@Value("${student4.number4}")
	private int number4;
	
	@Value("${student4.name4}")
	private String name4;
	
	@GetMapping("/test1")
	public String test1() {
		
		System.out.printf("student1.number1 : %d\n", number1);
		System.out.printf("student1.name1 : %s\n", name1);
		System.out.printf("student2.number2 : %d\n", number2);
		System.out.printf("student2.name2 : %s\n", name2);
		
		System.out.printf("student3.number3 : %d\n", number3);
		System.out.printf("student3.name3 : %s\n", name3);
		System.out.printf("student4.number4 : %d\n", number4);
		System.out.printf("student4.name4 : %s\n", name4);
		
		return "test1";
	}
}
