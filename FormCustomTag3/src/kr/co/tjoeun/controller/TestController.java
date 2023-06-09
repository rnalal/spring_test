package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.BeanData;
import kr.co.tjoeun.beans.BeanKeyValue;

@Controller
public class TestController {
	@GetMapping("/test1")
	public String test1(BeanData bean, Model model) {
		bean.setData1("더조은학원");
		bean.setData2("풀스택개발자과정");
		bean.setData3("자바웹개발과정");
		bean.setData4("데이터분석과정");
		
		String[] checkList = {"C언어과정", "Spring과정"};	//check되어 있는 문자열 만드는 list
		bean.setData5(checkList);
		bean.setData6(checkList);
		bean.setData7(checkList);
		bean.setData8(checkList);
		
		String[] dataArray2 = {"데이터분석과정", "풀스택개발자과정","C언어과정", "Spring과정", "자바웹개발과정"};
		model.addAttribute("dataArray2", dataArray2);
		
		
		ArrayList<String> dataList3 = new ArrayList<String>();
		dataList3.add("데이터분석과정");
		dataList3.add("풀스택개발자과정");
		dataList3.add("자바웹개발과정");
		dataList3.add("C언어과정");
		model.addAttribute("dataList3", dataList3);
	
		
		
/*		String[] dataList1 = {"데이터분석", "풀스택개발자과정", "자바웹개발과정"};
		model.addAttribute("dataList1", dataList1);*/
		
		String[] dataArray1 = {"데이터분석과정", "풀스택개발과정", "자바웹개발과정" };
		model.addAttribute("dataArray1", dataArray1);
		
		ArrayList<String> dataList1 = new ArrayList<String>();
		dataList1.add("데이터분석과정");
		dataList1.add("풀스택개발자과정");
		dataList1.add("자바웹개발과정");
		model.addAttribute("dataList1", dataList1);
		
		BeanKeyValue key_bean1 = new BeanKeyValue();
		BeanKeyValue key_bean2 = new BeanKeyValue();
		BeanKeyValue key_bean3 = new BeanKeyValue();
		BeanKeyValue key_bean4 = new BeanKeyValue();
		
		key_bean1.setKey("과정1");
		key_bean1.setValue("데이터분석과정");
		key_bean2.setKey("과정2");
		key_bean2.setValue("풀스택개발자과정");
		key_bean3.setKey("과정3");
		key_bean3.setValue("자바웹개발과정");
		key_bean3.setKey("과정4");
		key_bean3.setValue("Spring과정");
		
		ArrayList<BeanKeyValue> dataList2 = new ArrayList<BeanKeyValue>();
		dataList2.add(key_bean1);
		dataList2.add(key_bean2);
		dataList2.add(key_bean3);
		model.addAttribute("dataList2", dataList2);
		
		//path="data8"
		ArrayList<BeanKeyValue> dataList4 = new ArrayList<BeanKeyValue>();
		dataList4.add(key_bean1);
		dataList4.add(key_bean2);
		dataList4.add(key_bean3);
		dataList4.add(key_bean4);
		model.addAttribute("dataList4", dataList4);
		
		bean.setData9("자바웹개발과정");
		bean.setData10("자바웹개발과정");
		bean.setData11("자바웹개발과정");
		bean.setData12("자바웹개발과정");
		
		String[] dataArray3 = {"데이터분석과정", "풀스택개발과정", "자바웹개발과정" };
		model.addAttribute("dataArray3", dataArray3);
		
		//list : path="data11"
		ArrayList<String> dataList5 = new ArrayList<String>();
		dataList1.add("데이터분석과정");
		dataList1.add("풀스택개발자과정");
		dataList1.add("자바웹개발과정");
		model.addAttribute("dataList5", dataList5);
		
		//path="data12"
		ArrayList<BeanKeyValue> dataList6 = new ArrayList<BeanKeyValue>();
		dataList6.add(key_bean1);
		dataList6.add(key_bean2);
		dataList6.add(key_bean3);
		dataList6.add(key_bean4);
		model.addAttribute("dataList6", dataList6);
		
		return "test1";
	}
}
