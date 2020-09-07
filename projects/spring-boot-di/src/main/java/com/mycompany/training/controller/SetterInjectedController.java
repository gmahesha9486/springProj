package com.mycompany.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.mycompany.training.services.GreetingService;


@Controller
public class SetterInjectedController {

	private GreetingService greetingService;
	
	@Autowired
	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}


	public String getGreeting() {
		
		return greetingService.sayGreeting();
	}
}
