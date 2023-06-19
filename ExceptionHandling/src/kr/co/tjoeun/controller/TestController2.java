package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController2 {

	@GetMapping("/exception2")
	public String exception2(Model model) {
		
		ArrayList<String> list1 = null;
		list1.add("더조은");
		
		return "exception2";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerException() {
		return "nullpointer_exception";
	}
}
