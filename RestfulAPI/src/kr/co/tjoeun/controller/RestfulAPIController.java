package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tjoeun.beans.TestBean;

@RestController
public class RestfulAPIController {

	@GetMapping("/rest_controller")
	public ResponseEntity<ArrayList<TestBean>> restController() {
		
		TestBean testBean1 = new TestBean("더조은", 123, 3.14, false);
		TestBean testBean2 = new TestBean("아이티", 465, 6.25, true);
		TestBean testBean3 = new TestBean("아카데미", 789, 8.15, false);
		
		ArrayList<TestBean> list1 = new ArrayList<>();
		list1.add(testBean1);
		list1.add(testBean2);
		list1.add(testBean3);
		
		ResponseEntity<ArrayList<TestBean>> entity = new ResponseEntity<ArrayList<TestBean>>(list1, HttpStatus.OK);
		
		return entity;
	}
	
	
}

