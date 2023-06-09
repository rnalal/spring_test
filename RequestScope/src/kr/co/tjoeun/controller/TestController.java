package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {
	// HttpServletRequest 객체를 주입받음
	@GetMapping("/test1")	
	public String test1(HttpServletRequest request) {
		
		// setAttribute : data를 requestScoper 라는 메모리 영역에 올림
		request.setAttribute("data1", "더조은아카데미");
		
		// redirect : browser에게 server쪽으로 어떤 요청(request)을 하라고 명령함
		// return "redirect:/result1";
		
		// forward : browser가 흐름이 변경되는 것을 인식하지 못함
		// 			 주소가 변경되지 않음(test1 유지됨)
		//			 HttpServletRequest 소멸되지 않음(메모리 상에서 유지됨)
		return "forward:/result1";
	}
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		
		//getAttribute : data를 requestScoper 라는 메모리 영역에서 가져옴		
		String data1 = (String)request.getAttribute("data1");
		System.out.printf("data1 : %s\n", data1);
		
		return "result1";
	}
	
	// Model 객체를 주입받음
	@GetMapping("/test2")
	public String test2(Model model) {
		/*
		 model.addAttribute를 사용해서
		 data를 메모리에 올리면
		 HttpServletRequest 객체에 저장됨
		 */
		model.addAttribute("data2", "자바웹");
		
		return "forward:/result2";
	}
	
	@GetMapping("/result2")
	public String result2(HttpServletRequest request) {
		String data2 = (String)request.getAttribute("data2");
		System.out.printf("data2 : %s\n" , data2);
		return "result2";
	}
	
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {
		
		// ModelAndView 객체를 사용해서 data를 메모리에 올리면
		// requestScoper 영역에서 HttpServletRequest 객체에 저장됨
		mv.addObject("data3", "스프링프로젝트");
		mv.setViewName("forward:/result3");
		
		return mv;
	}
	
	@GetMapping("/result3")
	public String result3(HttpServletRequest request) {
		String data3 = (String)request.getAttribute("data3");
		System.out.printf("data3 : %s\n", data3);
		
		return "result3";	
	}
	
	@GetMapping("/testBean1")
	public String testBean1(Model model) {
		TestBean1 bean1 = new TestBean1();
		
		bean1.setData1("스프링");
		bean1.setData2("웹개발");
		
		model.addAttribute("bean1", bean1);
		
		return "forward:/result4";
	}
	
	@GetMapping("/result4")
	public String result4(HttpServletRequest request) {
		
		TestBean1 bean1 = (TestBean1)request.getAttribute("bean1");
		System.out.printf("bean1.data1 : %s\n", bean1.getData1());
		System.out.printf("bean1.data2 : %s\n", bean1.getData2());
		
		return "result4";
	}
	
	/*
		 @GetMapping("/testBean1_1") public String
		 testBean1_1(@ModelAttribute("bean1")TestBean1 bean1) {
		 bean1.setData1("자바개발자"); bean1.setData2("파이썬개발자");
		 
		 return "testBean1_1";  }
	 */
	
	 @GetMapping("/testBean1_1") public String
	 testBean1_1(@ModelAttribute("bean1")TestBean1 bean1) {
	 bean1.setData1("자바개발자"); bean1.setData2("파이썬개발자");
	 
	 return "forward:/result5"; }
	
	@GetMapping("/result5")
	//public String result5(@ModelAttribute("bean1")TestBean1 bean1) {
	public String result5(HttpServletRequest request) {
		
		TestBean1 bean1 = (TestBean1)request.getAttribute("bean1");
		
		System.out.printf("bean1.data1 : %s\n" , bean1.getData1());
		System.out.printf("bean1.data2 : %s\n" , bean1.getData2());
		return "result5";
	}
}
