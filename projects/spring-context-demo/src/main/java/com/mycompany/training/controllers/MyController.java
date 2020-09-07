package com.mycompany.training.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

	public String myMethod() {
		
		System.out.println("Inside the method: myMethod");
		return "Hello World";
	}
}
