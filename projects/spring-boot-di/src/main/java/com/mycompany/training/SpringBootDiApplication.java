package com.mycompany.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mycompany.training.controller.ConstructorInjectedController;
import com.mycompany.training.controller.MyController;
import com.mycompany.training.controller.PropertyInjectedController;
import com.mycompany.training.controller.SetterInjectedController;

@SpringBootApplication
public class SpringBootDiApplication {

	public static void main(String[] args) {
		
		ApplicationContext context =  SpringApplication.run(SpringBootDiApplication.class, args);
		
		// Dependency Injection using Spring
		
		PropertyInjectedController propController  = (PropertyInjectedController)context.getBean("propertyInjectedController");
		System.out.println(propController.getGreeting());
		
		SetterInjectedController setterController = (SetterInjectedController)context.getBean("setterInjectedController");
		System.out.println(setterController.getGreeting());
		
		ConstructorInjectedController consController = (ConstructorInjectedController)context.getBean("constructorInjectedController");
		System.out.println(consController.getGreeting());
		 
		
		//MyController controller = (MyController)context.getBean("myController");
		//controller.testMethod();
	}

}
