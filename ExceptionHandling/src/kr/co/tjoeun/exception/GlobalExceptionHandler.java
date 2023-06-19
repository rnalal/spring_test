package kr.co.tjoeun.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
	public String nullpointerException() {
		return "global_null_pointer_exception";
	}
}
