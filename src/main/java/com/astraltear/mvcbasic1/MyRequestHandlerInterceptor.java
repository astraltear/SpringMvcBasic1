package com.astraltear.mvcbasic1;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyRequestHandlerInterceptor implements HandlerInterceptor {
	private static Logger logger = LoggerFactory.getLogger(MyRequestHandlerInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("MyRequestHandlerInterceptor::afterCompletion 이 메소드는 요청의 처리가 완료된 후 DispatcherServlet이 뷰를 생성한 후 필요한 정리 작업을 수행");

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("MyRequestHandlerInterceptor::postHandle 이 메소드는 컨트롤러가 요청을 처리한 후 DispatcherServlet이 뷰를 생성하기 전에 호출 ");

	}

//	http://localhost:8080/mvcbasic1/paramModelAttr?a=b&c=d
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		이 메소드는 컨트롤러가 요청을 처리하기 전에 호출된다. true를 반환해야 컨트롤러를 호출한다.
		logger.info("MyRequestHandlerInterceptor::preHandle HTTP method:"+request.getMethod());
		
		Enumeration<String> requestNames = request.getParameterNames();
		while (requestNames.hasMoreElements()) {
			String name = (String) requestNames.nextElement();
			String value = request.getParameter(name);
			
			logger.info("MyRequestHandlerInterceptor::preHandle name["+name+"]value["+value+"]");
			
		}
		
		return true; 
		
	}

}
