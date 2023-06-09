package kr.co.tjoeun.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.beans.BeansData;
import kr.co.tjoeun.beans.BeansData2;
import kr.co.tjoeun.beans.BeansData3;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1Get(@RequestParam Map<String, String> map) {
		String strNum1 = map.get("num1");
		String strNum2 = map.get("num2");
		String numbers = map.get("numbers");
		
		System.out.printf("num1 : %s\n", strNum1);
		System.out.printf("num2 : %s\n", strNum2);
		System.out.printf("numbers : %s\n", numbers);
		
		return "result";
	}
	@GetMapping("/test2")
	public String test2Get(@RequestParam Map<String, String> map,
			               @RequestParam List<String> numbers) {
		String num1 = map.get("num1");
		String num2 = map.get("num2");
		String numberMap = map.get("numbers");
		
		System.out.printf("num1    : %s\n", num1);
		System.out.printf("num2    : %s\n", num2);
		System.out.printf("numbers : %s\n", numberMap);
				
		System.out.println("-- 같은 이름으로 전달된 2 개 의 data --");
		int index = 0;
		for(String strNum : numbers) {
			System.out.printf("numbers[%d] : %s\n", index, strNum);
			index +=1;
		}
		
		return "result";
	}
	@GetMapping("/test3")
	public String test3Get(@RequestParam Map<String, String> map,
			               @RequestParam List<String> numbers) {
		String strNum1 = map.get("num1");
		String strNum2 = map.get("num2");
		String numberMap = map.get("numbers");
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int number = Integer.parseInt(numberMap);
		
		System.out.printf("num1    : %d\n", num1);
		System.out.printf("num2    : %d\n", num2);
		System.out.printf("numbers : %d\n", number);
				
		System.out.println("-- 같은 이름으로 전달된 2 개 의 data --");
		int index = 0;
		for(String strNmber : numbers) {
			System.out.printf("strNmber[%d] : %s\n", index, strNmber);
			index +=1;
		}
		
		return "result";
	}
	
	@GetMapping("test4")
	public String test4Get(@ModelAttribute BeansData bean1,
						   @ModelAttribute BeansData2 bean2,
						   @ModelAttribute BeansData3 bean3) {
		System.out.println("-- BeansData --");
		System.out.printf("bean1.num1 : %d\n", bean1.getNum1());
		System.out.printf("bean1.num2 : %d\n", bean1.getNum2());
		
		int index = 0;
		for(int number : bean1.getNumbers()){
			System.out.printf("bean1.number[%d] : %d\n", index, number);
			index += 1;
		}
		System.out.println("-- BeansData2 --");		
		System.out.printf("bean2.num1 : %d\n", bean2.getNum1());
		System.out.printf("bean2.num2 : %d\n", bean2.getNum2());
		
		index= 0;
		for(int number : bean2.getNumbers()){
			System.out.printf("bean2.number[%d] : %d\n", index, number);
			index += 1;
		}
		
		System.out.println("-- BeansData3 --");		
		System.out.printf("bean3.num1 : %d\n", bean3.getNum1());
		System.out.printf("bean3.num2 : %d\n", bean3.getNum2());
		
		index = 0;
		for(int number : bean3.getNumbers()){
			System.out.printf("bean3.number[%d] : %d\n", index, number);
			index += 1;
		}
		
		return "result";
	}
	
	@GetMapping("test5")
	public String test5Get(BeansData bean1, BeansData2 bean2, BeansData3 bean3) {
		System.out.println("-- BeansData --");
		System.out.printf("bean1.num1 : %d\n", bean1.getNum1());
		System.out.printf("bean1.num2 : %d\n", bean1.getNum2());
		
		int index = 0;
		for(int number : bean1.getNumbers()){
			System.out.printf("bean1.number[%d] : %d\n", index, number);
			index += 1;
		}
		System.out.println("-- BeansData2 --");		
		System.out.printf("bean2.num1 : %d\n", bean2.getNum1());
		System.out.printf("bean2.num2 : %d\n", bean2.getNum2());
		
		index= 0;
		for(int number : bean2.getNumbers()){
			System.out.printf("bean2.number[%d] : %d\n", index, number);
			index += 1;
		}
		
		System.out.println("-- BeansData3 --");		
		System.out.printf("bean3.num1 : %d\n", bean3.getNum1());
		System.out.printf("bean3.num2 : %d\n", bean3.getNum2());
		
		index = 0;
		for(int number : bean3.getNumbers()){
			System.out.printf("bean3.number[%d] : %d\n", index, number);
			index += 1;
		}
		
		return "result";
	}
}







