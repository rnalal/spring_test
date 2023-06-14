package kr.co.tjoeun.beans;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TestBean1 {
	
	@Size(min=2, max=10)
	private String data1;
	
	private String data2;
	private String data3;

	// 기본 생성자에서 화면에 나오는 기본값 설정하기
	public TestBean1() {
		this.data1 = "더조은";
	}	
}
