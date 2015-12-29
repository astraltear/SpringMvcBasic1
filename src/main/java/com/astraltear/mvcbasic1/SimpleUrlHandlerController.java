package com.astraltear.mvcbasic1;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleUrlHandlerController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map<String, String> modelData = new HashMap<String, String>();
		modelData.put("msg", "SimpleUrlHandlerController handleRequest!");
		return new ModelAndView("simpleurlhandle",modelData);
	}

}
