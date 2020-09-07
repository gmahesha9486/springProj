package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.mycompany.training.service.EmployeeService;

@Controller
public class TestController {

	@Autowired
	@Qualifier("libraryServiceImpl")
	public EmployeeService empService;
	
	public void testContolMethod() {
		
		empService.serviceMethod();
	}
	
}
