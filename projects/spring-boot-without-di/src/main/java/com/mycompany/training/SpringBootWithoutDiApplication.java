package com.mycompany.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mycompany.training.controller.ConstructorInjectedController;
import com.mycompany.training.controller.PropertyInjectedController;
import com.mycompany.training.controller.SetterInjectedController;
import com.mycompany.training.services.GreetingServiceImpl;

@SpringBootApplication
public class SpringBootWithoutDiApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootWithoutDiApplication.class, args);
		
		// Dependency Injection without Spring
		PropertyInjectedController propController  = new PropertyInjectedController();
		propController.greetingService = new GreetingServiceImpl();
		System.out.println(propController.getGreeting());
				
		SetterInjectedController setterController = new SetterInjectedController();
		setterController.setGreetingService(new GreetingServiceImpl());
		System.out.println(setterController.getGreeting());
				
		ConstructorInjectedController consController = new ConstructorInjectedController(new GreetingServiceImpl());
		System.out.println(consController.getGreeting());
	}

}
