package kr.co.tjoeun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Spring MVC project 에 관련된 설정을 하는 클래스: servlet-context.xml 역할을 하는 클래스
// ServletAppContext 의 객체는 SpringConfigClass 클래스의 onStartup 메소드에서 생성함
@Configuration
// @Controller 어노테이션이 설정된 클래스를 Controller 로 등록하는 Annotation
@EnableWebMvc
// scan 할 bean 들이 모여 있는 package 지정하는 Annotation
@ComponentScan("kr.co.tjoeun.controller")
@ComponentScan("kr.co.tjoeun.beans")
public class ServletAppContext implements WebMvcConfigurer{
	
	// Controller 의 메소드에서 반환하는 문자열의 prefix 와 suffix 경로 정보 설정하기
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {	
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// 정적 파일 경로 지정하기: HTML 에서 사용하는 이미지, 사운드, js, CSS 등
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	
	
	
}
