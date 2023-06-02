package kr.co.tjoeun.model;

import javax.servlet.http.HttpServletRequest;

public class Test2Service {

	public static int minus(HttpServletRequest request) {
		String strNumber3 = request.getParameter("number3");
		String strNumber4 = request.getParameter("number4");
		
		int number3 = Integer.parseInt(strNumber3);
		int number4 = Integer.parseInt(strNumber4);
		
		int result = number3 - number4;
		
		return result;
	}
}
