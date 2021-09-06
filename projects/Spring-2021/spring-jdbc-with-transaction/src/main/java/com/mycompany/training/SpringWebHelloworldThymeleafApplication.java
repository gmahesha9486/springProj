package com.mycompany.training;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mycompany.training.controller.TestController;
import com.mycompany.training.model.Student;
import com.mycompany.training.repository.StudentJdbcRepository;
 

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=true)
public class SpringWebHelloworldThymeleafApplication   {
 	
	private static final Logger logger = LoggerFactory.getLogger(SpringWebHelloworldThymeleafApplication.class);
	
	public static void main(String[] args) {
		
	 	
		ApplicationContext context = SpringApplication.run(SpringWebHelloworldThymeleafApplication.class, args);
	
		  logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
	      
	      
		TestController obj = (TestController)context.getBean("testController");
		obj.doSomeStuff();
		
	}

	
}
