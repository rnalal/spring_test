package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;
import kr.co.tjoeun.beans.TestBean3;
import kr.co.tjoeun.beans.TestBean4;

@Controller
public class TestController {
	
	/*
	 xml 설정방식으로 할 때
	 scope="request" 인 경우에는
	 @Lazy를 사용해야 요청이 들어올 때만 bean 객체가 주입됨 
	 */
	@Autowired
	@Lazy
	TestBean1 testBean1;
	
	@Resource(name="testBean2")
	@Lazy
	TestBean2 testBean2;
	
	@Autowired
	TestBean3 testBean3;
	
	@Resource(name="testBean4")
	TestBean4 testBean4;
		
	@GetMapping("testBean1")
	public String testBean1() {
		testBean1.setData1("자바웹");
		testBean1.setData2("프레임워크");
		
		testBean2.setData3("파이썬");
		testBean2.setData4("데이터분석");
		
		testBean3.setData5("서블릿");
		testBean3.setData6("JSP");
		
		testBean4.setData7("프론트");
		testBean4.setData8("자바스크립트");
		
		// forwarding: 새로운 요청이 발생하지 않음
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String reuslt(Model model) {
		
		System.out.printf("testBean1.data1: %s\n", testBean1.getData1());
		System.out.printf("testBean1.data2: %s\n", testBean1.getData2());
		
		System.out.printf("testBean2.data3: %s\n", testBean2.getData3());
		System.out.printf("testBean2.data4: %s\n", testBean2.getData4());
		
		System.out.printf("testBean3.data5: %s\n", testBean3.getData5());
		System.out.printf("testBean3.data6: %s\n", testBean3.getData6());
		
		System.out.printf("testBean4.data7: %s\n", testBean4.getData7());
		System.out.printf("testBean4.data8: %s\n", testBean4.getData8());
		
		model.addAttribute("testBean1", testBean1);
		
		// xml 방식으로 설정할 때만(java방식은 해당안됨!)
		// <bean class="kr.co.tjoeun.beans.TestBean2" scope="request" id="testBean2"/>
		// 에서 scope="request" id="testBean2"이 두 설정을 같이 하면
		// 자동으로 주입도 되고, request scope 로딩도 자동으로 됨
		// model.addAttribute("testBean2", testBean2); <-- 이 부분을 호출하지 않아도 됨
		
		model.addAttribute("testBean3", testBean3);
		model.addAttribute("testBean4", testBean4);
		
		return "result1";
	}
}
