package com.mycompany.training.controller;

import com.mycompany.training.services.GreetingService;

public class PropertyInjectedController {
	
	public GreetingService greetingService;
	
	public String getGreeting() {
		
		return greetingService.sayGreeting();
	}

}
