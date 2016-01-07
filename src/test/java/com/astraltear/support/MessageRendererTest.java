package com.astraltear.support;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.astraltear.mvcbasic1.di.MessageRenderer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/di.xml"})
public class MessageRendererTest {

	@Autowired
	private MessageRenderer messageRenderer;
	
	@Test
	public void renderer() {
		messageRenderer.render();
	}

}
