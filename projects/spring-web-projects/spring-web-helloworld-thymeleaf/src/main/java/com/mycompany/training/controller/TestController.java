package com.mycompany.training.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {

	@RequestMapping("/hello")
	public String testMethod() {
		
		System.out.println("-============ Inside testMethod ===============");
		return "hello";
	}
	
	
	@RequestMapping("/book")
	public ModelAndView testBookMethod(Model model) {
		 
		List<String> cities = new ArrayList<>();
		cities.add("Blore");
		cities.add("Mysore");

        Map<String, Object> params = new HashMap<>();
        params.put("cities", cities);
        params.put("title", "myTitle");
        
        return new ModelAndView("books/book", params);
        
        
	}
}
