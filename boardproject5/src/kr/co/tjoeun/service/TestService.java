package kr.co.tjoeun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.dao.TestDAO;

@Service
public class TestService {
	
	// @Autowired 없으면, 
	// TestDAO testDAO = new TestDAO(); 직접 입력해야함
	@Autowired
	TestDAO testDAO;
	
	public String testServiceMethod() {
		String str1 = testDAO.testDaoMethod();
		return str1;
	}
}
