package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {
	
	@GetMapping("/input_data")
	public String inputData(TestBean1 bean1) {		
		return "input_data";
	}
	
	@PostMapping("/input_result")
	// public String inputProcedure( @ModelAttribute("bean1") TestBean1 bean1) { --> 이렇게 할려면 input_procedure.jsp 에서 ${bean1.data1}로 불러와야함
	public String inputProcedure(@Valid TestBean1 bean1, BindingResult result) {
		System.out.printf("data1 : %s\n", bean1.getData1());
		System.out.printf("data2 : %s\n", bean1.getData2());
		
		System.out.printf("BindingResult : %s\n", result);
		
		if(result.hasErrors()) {
			// 유효성 위반 결과 모두 가져옴
			for(ObjectError error : result.getAllErrors()) {
				System.out.printf("에러메세지  : %s\n", error.getDefaultMessage());
				System.out.printf("에러 코드   : %s\n", error.getCode());
				System.out.printf("object name : %s\n", error.getObjectName());
				
				String[] errorsCodes = error.getCodes();
				for(String code : errorsCodes) {
					System.out.println(code);
				}
				if(errorsCodes[0].equals("Size.testBean1.data1")) {
					System.out.println("data1 은 2 ~ 10 글자만 입력할 수 있습니다.");
				} else if(errorsCodes[0].equals("Max.testBean1.data2")) {
					System.out.println("data2 는 100 이하의 값만 입력할 수 있습니다.");
				}
				
				System.out.println("--------------------------------------------");
			}
			return "input_data"; // 입력 실패하면 input_result.jsp 로 넘어감
		}
		
		return "input_success"; // 입력 성공하면 input_success.jsp 로 넘어감
	}
}


/*
에러메세지  : 100 이하여야 합니다
에러 코드   : Max
object name : testBean1
Max.testBean1.data2
Max.data2
Max.int
Max
--------------------------------------------
에러메세지  : 크기가 2에서 10 사이여야 합니다
에러 코드   : Size
object name : testBean1
Size.testBean1.data1
Size.data1
Size.java.lang.String
Size
------------ 

*/
