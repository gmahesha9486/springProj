package com.mycompany.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.controller.MyController;
import com.controller.MyComponent;
import com.controller.MyRepository;
import com.controller.MyService;
import com.controller.TestController;
import com.mycompany.training.service.EmployeeService;
import com.mycompany.training.service.*;


@SpringBootApplication
@ComponentScan(basePackages = {"com.controller","com.mycompany.training"}) 
public class SpringAnnotationExample {

	public static void main(String[] args) {
		
		ApplicationContext context =  SpringApplication.run(SpringAnnotationExample.class, args);
		
		
		MyController controllerObj = (MyController)context.getBean("myController");
		controllerObj.testMethod();
		
		MyComponent componentObj = (MyComponent)context.getBean("myComponent");
		componentObj.testMethod();
		
		MyRepository repositoryObj = (MyRepository)context.getBean("myRepository");
		repositoryObj.testMethod();
		
		MyService serviceObj = (MyService)context.getBean("myService");
		serviceObj.testMethod();
		
		
		TestController testControlObj = (TestController)context.getBean("testController");
		testControlObj.testContolMethod(); 
		
	}

}
