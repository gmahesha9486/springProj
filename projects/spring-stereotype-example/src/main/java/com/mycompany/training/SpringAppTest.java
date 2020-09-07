package com.mycompany.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.mycompany.training.controller.MyController;
import com.mycompany.training.controller.MyComponent;
import com.mycompany.training.controller.MyRepository;
import com.mycompany.training.controller.MyService;


@SpringBootApplication
public class SpringAppTest {

	public static void main(String[] args) {
		
		ApplicationContext context =  SpringApplication.run(SpringAppTest.class, args);
		
		
		MyController controllerObj = (MyController)context.getBean("myController");
		controllerObj.testMethod();
		
		MyComponent componentObj = (MyComponent)context.getBean("myComponent");
		componentObj.testMethod();
		
		MyRepository repositoryObj = (MyRepository)context.getBean("myRepository");
		repositoryObj.testMethod();
		
		MyService serviceObj = (MyService)context.getBean("myService");
		serviceObj.testMethod();
		
		
	}

}
