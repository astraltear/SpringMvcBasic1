package com.astraltear.mvcbasic1.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayofWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// if this method returns true then application will further handle the request
		// if this methods returns false then application will not further handle the request
		
		Calendar cal = Calendar.getInstance();
		
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		
		if(dayOfWeek == 1) {
			response.getWriter().write("the website is closed on Sunday!!");
			return false;
		}
		
		return true;
	}

}
