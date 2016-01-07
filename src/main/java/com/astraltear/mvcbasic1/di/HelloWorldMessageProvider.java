package com.astraltear.mvcbasic1.di;

public class HelloWorldMessageProvider implements MessageProvider {

	@Override
	public String getMessage() {
		return "Hello World";
	}

}
