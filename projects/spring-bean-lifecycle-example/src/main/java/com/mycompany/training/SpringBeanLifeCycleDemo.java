package com.mycompany.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mycompany.training.controller.MyController;

@SpringBootApplication
public class SpringBeanLifeCycleDemo {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringBeanLifeCycleDemo.class, args);
		  
		//MyController controller = (MyController)context.getBean("myController");
		 
	}	
}
