package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.validator.TestBean1Validator;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String inputData(TestBean1 bean1) {
		return "input_data";
	}
	
	@PostMapping("/input_procedure")
	public String inputProcedure(@Valid TestBean1 bean1, BindingResult result) {
		if(result.hasErrors()) {
			return "input_data";
		}
		return "input_success";
	}
	
	// Validator 등록하기
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		TestBean1Validator validator1 = new TestBean1Validator();
		binder.addValidators(validator1);
		// binder.addValidators(validator1, validator2, validator3, ...);
	}	   
}
