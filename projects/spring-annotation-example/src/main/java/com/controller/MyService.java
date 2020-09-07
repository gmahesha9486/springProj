package com.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class MyService {

	public MyService() {
		System.out.println("Constructor of MyService class");
	}
	
	public void testMethod() {
		
		System.out.println("MyService method.");
	}
}
