package kr.co.tjoeun.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.tjoeun.beans.TestBean1;

public class TestBean1Validator implements Validator {

	// 유효성 검사할 data 를 가지고 있는 객체가 유효성 검사가 가능한지 확인함
	@Override
	public boolean supports(Class<?> clazz) {
		return TestBean1.class.isAssignableFrom(clazz);
	}

	// 유효성 검사하는 메소드	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "data2", "errors2");
		//ValidationUtils.rejectIfEmptyOrWhitespace(error객체, "property이름", "코드이름")
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "errors3");
		
	}

}
