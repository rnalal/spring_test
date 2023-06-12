package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.tjoeun.beans.TestBeanByName;
import kr.co.tjoeun.beans.TestBeanByType;

// 상속이 없음 : project 작업시 사용할 bean을 정의하는 클래스 
@Configuration
public class RootAppContext {

	// (Controller 에서 타입으로 빈 주입받음) type으로 주입받음
	@Bean
	@SessionScope
	public TestBeanByType testBeanByType() {
		return new TestBeanByType() ;
	}
	
	// (Controller 에서) name(이름)으로 주입받음
	@Bean("sessionBean2")
	@SessionScope
	public TestBeanByName testBeanByName() {
		return new TestBeanByName();
	}
}
