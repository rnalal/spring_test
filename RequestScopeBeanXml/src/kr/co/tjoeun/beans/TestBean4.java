package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

		// byName 방식
@Component(value="testBean4")
@RequestScope
public class TestBean4 {
	private String data7;
	private String data8;
	
	public String getData7() {
		return data7;
	}
	public void setData7(String data7) {
		this.data7 = data7;
	}
	public String getData8() {
		return data8;
	}
	public void setData8(String data8) {
		this.data8 = data8;
	}
}
