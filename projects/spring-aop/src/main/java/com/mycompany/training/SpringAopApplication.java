package com.mycompany.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.mycompany.training.controller.TestController;
import com.mycompany.training.service.MyService;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringAopApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringAopApplication.class, args);
		
		TestController obj = (TestController)context.getBean("testController");
		obj.test("h");
		
		MyService service = (MyService)context.getBean("myService");
		service.myMethod();
		
	}

}
