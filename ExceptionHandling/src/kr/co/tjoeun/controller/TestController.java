package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/exception1")
	public String exception1(Model model) {
		
		// int[] arr1 = {1, 2, 3, 4, 5};
		
		// System.out.printf("arr1[0] : %d\n", arr1[0]);		

		// model.addAttribute("arr1_0", arr1[5]);
		
		ArrayList<String> list1 = null;
		list1.add("더조은");
		
		return "exception1";
	}
	
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public String arrayException() {
		return "array_exception";
	}
}
