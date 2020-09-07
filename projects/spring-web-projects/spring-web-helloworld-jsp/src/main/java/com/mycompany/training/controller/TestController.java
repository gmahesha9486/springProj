package com.mycompany.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/hello")
	public String testMessage(ModelMap model) {
		
		System.out.println("Am i printing ? =============================");
		return "welcome";
	}
	
	@RequestMapping("/test")
	public String testMethod(ModelMap model) {
		
		System.out.println("This is Test Method");
		
		String name="Mahesh";
		String password="password123";
		
		model.put("name", name);
        model.put("password", password);
        
		return "test";
	}
	
}
