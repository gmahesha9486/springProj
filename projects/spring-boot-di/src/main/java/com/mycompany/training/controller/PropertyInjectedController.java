package com.mycompany.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import com.mycompany.training.services.GreetingService;


@Controller
public class PropertyInjectedController {
 	
	@Autowired
	public GreetingService greetingService;
	
	public String getGreeting() {
		
		 
		
		return greetingService.sayGreeting();
	}

}
