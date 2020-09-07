package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

	@Value("${sourceLocation:d:/temp/input}")
    private String source;
	
	@Value("${test.appName:springApp}")
	private String name;
	
	public void testMethod() {
		
		System.out.println("Value of source="+source);
		System.out.println("Value of name="+name);
		
		System.out.println("MyComponent method.");
	}
}
