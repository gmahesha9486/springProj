package com.mycompany.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mycompany.training.controllers.MyController;

@SpringBootApplication
public class SpringContextDemoApplication {

	public static void main(String[] args) {
		
		ApplicationContext context =  SpringApplication.run(SpringContextDemoApplication.class, args);
		MyController obj = (MyController)context.getBean("myController");
		
		String result = obj.myMethod();
		System.out.println("Value of result is: "+result);
		
	}

}
