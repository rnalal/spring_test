package kr.co.tjoeun.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class TestBean1 {
	
	@NotEmpty
	private String data1;
	
	@NotBlank
	private String data2;
	
	@Positive
	private int data3;
	
	@PositiveOrZero
	private int data4;
	
	@Negative
	private int data5;
	
	@NegativeOrZero
	private int data6;
	
	@Email
	private String data7;

	// 기본 생성자에서 화면에 나오는 기본값 설정하기
	public TestBean1() {
		this.data1 = "더조은";
		this.data2 = "아카데미";
		this.data3 = 50;
		this.data4 = 30;	
		this.data5 = -10;
		this.data6 = -5;
		this.data7 = "spring@tjoeun.co.kr";
	}	
}
