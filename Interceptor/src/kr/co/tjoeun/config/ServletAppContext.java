package kr.co.tjoeun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.tjoeun.interceptor.TestInterceptor1;
import kr.co.tjoeun.interceptor.TestInterceptor2;
import kr.co.tjoeun.interceptor.TestInterceptor3;
import kr.co.tjoeun.interceptor.TestInterceptor4;
import kr.co.tjoeun.interceptor.TestInterceptor5;
import kr.co.tjoeun.interceptor.TestInterceptor6;
import kr.co.tjoeun.interceptor.TestInterceptor7;
import kr.co.tjoeun.interceptor.TestInterceptor8;

// Spring MVC project에 관련된 설정을 하는 클래스 : servlet-context.xml 역할을 하는 클래스
// ServletAppContext의 객체는 SpringConfigClass 클래스의 onStartup 메소드에서 생성함
@Configuration
// @Controller 어노테이션이 설정된 클래스를 Controller로 등록하는 Annotation
@EnableWebMvc
// scan 할 bean 들이 모여 있는 package 지정하는 Annotation
@ComponentScan("kr.co.tjoeun.controller")
public class ServletAppContext implements WebMvcConfigurer{
	
	// Controller 의 메소드에서 반환하는 문자열의 prefix와 suffix 경로 정보 설정하기
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
		
	}	
	// 정적 파일 경로 지정하기
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		
		TestInterceptor1 inter1 = new TestInterceptor1();		
		TestInterceptor2 inter2 = new TestInterceptor2();
		TestInterceptor3 inter3 = new TestInterceptor3();
		TestInterceptor4 inter4 = new TestInterceptor4();
		TestInterceptor5 inter5 = new TestInterceptor5();
		TestInterceptor6 inter6 = new TestInterceptor6();
		TestInterceptor7 inter7 = new TestInterceptor7();
		TestInterceptor8 inter8 = new TestInterceptor8();
		
		InterceptorRegistration reg1 = registry.addInterceptor(inter1);
		InterceptorRegistration reg2 = registry.addInterceptor(inter2);
		InterceptorRegistration reg3 = registry.addInterceptor(inter3);
		InterceptorRegistration reg4 = registry.addInterceptor(inter4);
		InterceptorRegistration reg5 = registry.addInterceptor(inter5);
		InterceptorRegistration reg6 = registry.addInterceptor(inter6);
		InterceptorRegistration reg7 = registry.addInterceptor(inter7);
		InterceptorRegistration reg8 = registry.addInterceptor(inter8);
		
		// InterceptorRegistration 클래스의
		// addPathPatterns 메소드의 argument 로 url pattern 를 지정함
		reg1.addPathPatterns("/test1");		
		reg2.addPathPatterns("/test1");
		
		reg3.addPathPatterns("/test2");
		
/*		reg4.addPathPatterns("/test1");
		reg4.addPathPatterns("/test2");	*/
		
		reg4.addPathPatterns("/test1", "/test2");
		
		reg5.addPathPatterns("/sub1/test3", "/sub1/test4");
		
		reg6.addPathPatterns("/*");
		
		reg7.addPathPatterns("/sub1/*");
		
		reg8.addPathPatterns("/**");
		
		reg8.excludePathPatterns("/*");
	}
}
