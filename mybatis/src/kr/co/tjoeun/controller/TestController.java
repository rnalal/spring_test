package kr.co.tjoeun.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.TestBean;

@Controller
public class TestController {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@GetMapping("/input_data")
	public String inputData() {
		return "input_data";
	}
	
	@PostMapping("/input_procedure")
	public String inputProcedure(TestBean testBean) {		
		sqlSessionTemplate.insert("test_db.insert_data", testBean);
		return "input_procedure";
	}
	
	@GetMapping("/read_data")
	public String readData(Model model){
		List<TestBean> testList = sqlSessionTemplate.selectList("test_db.select_data");
		model.addAttribute("testList", testList);
		return "read_data";
	}
}
