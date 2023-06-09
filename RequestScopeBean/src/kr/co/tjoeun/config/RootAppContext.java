package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;

// 상속이 없음 : project 작업시 사용할 bean을 정의하는 클래스 
@Configuration
public class RootAppContext {
	
	// @RequestScope: Bean 이 주입되는 시기 --> 새로운 요청이 발생할 때
	@Bean
	@RequestScope
	public TestBean1 testBean1() {
		return new TestBean1();
	}
	
	@Bean("testBean2")
	@RequestScope
	public TestBean2 testBean2() {
		return new TestBean2();
	}
}
