package com.mycompany.training.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
@Lazy
public class MyController {

	public MyController() {
		System.out.println(" ================= Constructor 123 =====================");
	}
	public String testMethod() {
		
		System.out.println("Hello world...........123!");
		return "Hello";
		
	}
}
