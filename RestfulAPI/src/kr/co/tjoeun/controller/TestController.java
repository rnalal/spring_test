package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/controller")
	public String controller() {
		
		return "controller";
	}
}
