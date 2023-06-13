package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;

// 상속이 없음: project 작업시 사용할 bean 을 정의하는 클래스
@Configuration
public class RootAppContext {

	@Bean
	@SessionScope
	public TestBean1 testBean1() {
		return new TestBean1();
	}
	
	@Bean("applicationBean2")
	@SessionScope
	public TestBean2 testBean2() {
		return new TestBean2();
	}
	
}
