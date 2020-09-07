package com.mycompany.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.mycompany.training.controller.MyController;
import com.mycompany.training.controller.MyProtoTypeController;


@SpringBootApplication
public class SpringBeanScopeExample {

public static void main(String[] args) {
		
		ApplicationContext context =  SpringApplication.run(SpringBeanScopeExample.class, args);
		
		  
		MyController controller = (MyController)context.getBean("myController");
		controller.setName("Spring");
		
		MyController obj = (MyController)context.getBean("myController");
		obj.setName("Java");
		
		System.out.println(controller.getName());
		System.out.println(obj.getName());
		
		
		MyProtoTypeController obj1 = (MyProtoTypeController)context.getBean("myProtoTypeController");
		obj1.setName("Type 1");
		
		MyProtoTypeController obj2 = (MyProtoTypeController)context.getBean("myProtoTypeController");
		obj2.setName("Type 2");
		
		System.out.println(obj1.getName());
		System.out.println(obj2.getName());
		
		
	}

}
