package kr.co.tjoeun.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/* 
 //1. WebApplicationInitializer 방식
  
// SpringConfigClass: web.xml 역할을 하는 클래스
public class SpringConfigClass implements WebApplicationInitializer {

	//WebApplicationInitializer 방식 
 	// project 실행 시 자동으로 호출됨
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	// System.out.println("onStartup() 메소드 - project 실행시 자동으로 호출됨");
		// Spring MVC project에 관련된 설정을 하는 클래스의( ServletAppContext )의 객체 생성하기
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext(); 
		servletAppContext.register(ServletAppContext.class);
		
		// 요청발생시 요청을 처리하는 Servlet을 
		// org.springframework.web.servlet.DispatcherServlet 으로 지정함
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		
		// xml 방식에서 <load-on-startup>1</load-on-startup> 설정한 부분
		servlet.setLoadOnStartup(1);
		
		
		 // xml 방식에서 <load-on-startup>appServlet</load-on-startup>
		 // 			 <url-pattern>/</url-pattern>
		 // 			 설정한 부분
		 
		servlet.addMapping("/");
		
		// Bean을 정의하는 클래스 지정하기  : RootAppContext
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext(); 
		rootAppContext.register(RootAppContext.class);
		
		// listener 설정하기
		ContextLoaderListener contextLoaderListener = new ContextLoaderListener(rootAppContext);
		servletContext.addListener(contextLoaderListener); 
		
		// Parameter Encoding Filter 설정하기 : 한글처리
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.addMappingForServletNames(null, false, "dispatcherServlet");
		
	} 
*/


// 2. AbstractAnnotationConfigDispatcherServletInitializer 방식

//SpringConfigClass: web.xml 역할을 하는 클래스
public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer {
	//DispatcherServlet에 Mapping할 요청 주소 설정
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	// Spring MVC project 설정을 위한 클래스 지정하기
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletAppContext.class};
	}
	
	// project에서 사용하는 Beans 들을 정의하기 위한 클래스 지정하기
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppContext.class};
	}
	
	// Parameter Encoding Filter 설정하기 : 한글처리
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodinFilter = new CharacterEncodingFilter();
		encodinFilter.setEncoding("UTF-8");
		return new Filter[] {encodinFilter};
	}
}

