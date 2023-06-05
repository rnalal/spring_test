package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");		
		String[] numbers = request.getParameterValues("numbers");
		
		System.out.println("number1 : "+ number1);
		System.out.println("number2 : "+ number2);
		
		int index = 0;
		for(String number : numbers) {
			System.out.println("numbers[" + index + "] : "+number);
			index += 1;
		}
		
		return "result";
	}
	
	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {
				
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");		
		String[] numbers = request.getParameterValues("numbers");
		
		System.out.println("number1 : "+ number1);
		System.out.println("number2 : "+ number2);
		
		if (numbers != null) {		
		int index = 0;
		for(String number : numbers) {
			System.out.println("numbers[" + index + "] : "+number);
			index += 1;
			}
		}	
		
		return "result";
	}
	
	@GetMapping("/test3")
	public String test3(WebRequest request) {
		
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");		
		String[] numbers = request.getParameterValues("numbers");
		
		System.out.println("number1 : "+ number1);
		System.out.println("number2 : "+ number2);
		
		int index = 0;
		for(String number : numbers) {
			System.out.println("numbers[" + index + "] : "+number);
			index += 1;
		}
		
		return "result";
	}
	
	@GetMapping("/test4/{num1}/{num2}/{num3}")
	public String test4(@PathVariable String num1,
						@PathVariable String num2,
						@PathVariable String num3) {
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		System.out.println("num3 : "+num3);		
		return "result";
	}
	
	
	@GetMapping("/test5/{n1}/{n2}/{n3}/{n4}")
	public String test5(@PathVariable int n1,
						@PathVariable int n2,
						@PathVariable int n3,
						@PathVariable int n4) {
		
		int sum = n1 + n2 + n3 + n4;
		System.out.println("합계 : "+ sum);
		return "result";
	}
	
	@GetMapping("/test6")
	public String test6(@RequestParam int num1,
						@RequestParam int num2,
						@RequestParam int[] nums) {
		System.out.println("num1 : " + num1 );
		System.out.println("num2 : " + num2 );
		System.out.println("nums[0] : " + nums[0] );
		System.out.println("nums[1] : " + nums[1] );
		
		int sum = num1 + num2 + nums[0] + nums[1];
		System.out.println("합계 : " + sum);
		
		return "result";
	}
	
	@GetMapping("/test7")
	public String test7(@RequestParam(value="num1") int number1,
						@RequestParam(value="num2") int number2,
						@RequestParam(value="nums") int[] numbers) {
		System.out.println("number1 : " + number1 );
		System.out.println("number2 : " + number2 );
		System.out.println("numbers[0] : " + numbers[0] );
		System.out.println("numbers[1] : " + numbers[1] );
		
		int sum = number1 + number2 + numbers[0] + numbers[1];
		System.out.println("합계 : " + sum);
		return "result"; 
	}
	
	// 요청에서 넘긴 값(num2)을 받지 않을 때는 문제가 없음
	@GetMapping("/test8")
	public String test8(@RequestParam int num1,
						@RequestParam int[] nums) {
		System.out.println("num1 : " + num1 );
		System.out.println("nums[0] : " + nums[0] );
		System.out.println("nums[1] : " + nums[1] );
		
		int sum = num1 + nums[0] + nums[1];
		System.out.println("합계 : " + sum);
		
		return "result";
	}
	
	// 넘어오지 않은 값(@RequestParam int num3)을 받는 경우
	// 400에러 발생함
	@GetMapping("/test9")
	public String test9(@RequestParam int num1,
						@RequestParam int num2,
						@RequestParam int num3,
						@RequestParam int[] nums) {
		System.out.println("num1 : " + num1 );
		System.out.println("num2 : " + num2 );
		System.out.println("num3 : " + num3 );
		System.out.println("nums[0] : " + nums[0] );
		System.out.println("nums[1] : " + nums[1] );
		
		int sum = num1 + num2 + num3 + nums[0] + nums[1];
		System.out.println("합계 : " + sum);
		
		return "result";
	}
	
	// 넘어오지 않은 값(num3, num4)을 받는 경우
	// required : false로 설정하면 지정된 이름의 파라미터가 없는 경우
	// 			   null이 주입됨
	// @RequestParam(required=false) int num3
	// 		ㄴ 일단 null 값으로 받은 다음 int type으로 형변환하려고 함 <-- 오류 발생
	// @RequestParam(required=false) int num4 <-- null을 주입받음
	@GetMapping("/test10")
	public String test10(@RequestParam int num1,
						@RequestParam int num2,
			/* @RequestParam(required=false) int num3, */
						@RequestParam(required=false) String num4,
						@RequestParam int[] nums) {
		System.out.println("num1 : " + num1 );
		System.out.println("num2 : " + num2 );
		/* System.out.println("num3 : " + num3 ); */
		System.out.println("num4 : " + num4 );
		System.out.println("nums[0] : " + nums[0] );
		System.out.println("nums[1] : " + nums[1] );
		
		/*
		 * int sum = num1 + num2 + num3 + num4 + nums[0] + nums[1]; System.out.println("합계 : "
		 * + sum);
		 */
		
		return "result";
	}
	
	// 넘어오지 않은 값(num3)을 받는 경우
	//  defaultValue="0"으로 설정하면 지정된 이름의 파라미터가 없는 경우
	// 				 "0"이 주입됨			   		
	@GetMapping("/test11")
	public String test11(@RequestParam int num1,
						 @RequestParam int num2,
						 @RequestParam(defaultValue="0") int num3, 
						 @RequestParam int[] nums) {
		System.out.println("num1 : " + num1 );
		System.out.println("num2 : " + num2 );
		System.out.println("num3 : " + num3 );
		System.out.println("nums[0] : " + nums[0] );
		System.out.println("nums[1] : " + nums[1] );
		

		 int sum = num1 + num2 + num3 + nums[0] + nums[1]; System.out.println("합계 : "+ sum);
		
		return "result";
	}
}