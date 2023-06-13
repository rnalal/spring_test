package kr.co.tjoeun.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
  @GetMapping("/save_cookie")
  public String saveCookie(HttpServletResponse response) {
  	
  	try {
  		// 한글인 경우 저장할 문자열을 encoding 함
  		String str1 = URLEncoder.encode("더조은", "UTF-8");
  		String str2 = URLEncoder.encode("아카데미", "UTF-8");
  		
  		Cookie ck1 = new Cookie("data1", str1);
  		Cookie ck2 = new Cookie("data2", str2);
  		
  		ck1.setMaxAge(60 * 60 * 24 * 365);
  		ck2.setMaxAge(60 * 60 * 24 * 365);
  		
  		response.addCookie(ck1);
  		response.addCookie(ck2);
  		
  	}catch(Exception e) {
  		e.printStackTrace();
  	}
  	
  	return "save_cookie";
  }
  @GetMapping("/load_cookie")
  public String loadCookie(HttpServletRequest request) {
  	
  	try {
  		
  		Cookie[] cks = request.getCookies();
  		
  		for(Cookie ck : cks) {
  			String str1 = URLDecoder.decode(ck.getValue(), "UTF-8");
  			
  			if(ck.getName().equals("data1")) {
  				System.out.printf("data1 : %s\n",str1);
  			}else if(ck.getName().equals("data2")) {
  				System.out.printf("data2 : %s\n",str1);
  			}
  			
  		}
  		
  		
  	}catch(Exception e) {
  		e.printStackTrace();
  	}
  	
  	return "load_cookie";
  }
  
  @GetMapping("/load_cookie2")
  public String loadCookie2(@CookieValue("data1") String cookie1, 
  		                      @CookieValue("data2") String cookie2){
  	
  	System.out.printf("cookie1 : %s\n",cookie1);
  	System.out.printf("cookie2 : %s\n",cookie2);
  	
  	return "load_cookie2";
  }
}





