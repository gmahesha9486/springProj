package com.mycompany.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.mycompany.training.services.GreetingService;


@Controller
public class ConstructorInjectedController {

	private final GreetingService greetingService;
	
	@Autowired  // This annotation on constructor is optional from Spring 4.2 onwards
	public ConstructorInjectedController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	public String getGreeting() {
		
		return greetingService.sayGreeting();
	}
}
