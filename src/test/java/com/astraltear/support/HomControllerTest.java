package com.astraltear.support;

import static org.junit.Assert.*;


import org.junit.Test;

import com.astraltear.mvcbasic1.HomeController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomControllerTest {

	@Test
	public void test() throws Exception {
		standaloneSetup(new HomeController()).build()
		.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("home"));
		
		
	}

}
