package com.astraltear.mvcbasic1.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRenderer {
	
	private MessageProvider messageProvider;

	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	public void render() {
		System.out.println(messageProvider.getMessage());
	}
	
	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("di.xml");
		MessageRenderer renderer = (MessageRenderer) context.getBean("messageRenderer");
		
		renderer.render();
	}
}
