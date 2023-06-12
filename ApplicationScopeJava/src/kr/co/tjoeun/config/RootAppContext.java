package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;

// 상속이 없음 : project 작업시 사용할 bean을 정의하는 클래스 
@Configuration
public class RootAppContext {
	
	// byType
	@Bean
	@ApplicationScope
	public TestBean1 applicationBean1() {
		return new TestBean1();
	}
	
	// byName
	@Bean("applicationBean2")
	@ApplicationScope
	public TestBean2 applicationBean2() {
		return new TestBean2();
	}
	
}
