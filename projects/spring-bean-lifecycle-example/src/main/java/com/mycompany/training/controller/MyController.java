package com.mycompany.training.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Lazy
public class MyController implements InitializingBean, DisposableBean , ApplicationContextAware, BeanNameAware {

	 public MyController() {
		 
		 System.out.println(" Constructor method of MyController");
	 }

	@Override
	public void destroy() throws Exception {

		System.out.println("Inside destroy method"); 
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		 
		System.out.println("Inside afterPropertiesSet method");
		
	}
	
	@PostConstruct
	public void myPostConstructMethod() {
		
		System.out.println("Inside myPostConstruct method");
	}
	
	@PreDestroy
	public void myPreDestroyMethod() {
		
		System.out.println("Inside myPreDestroy method");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		 
		System.out.println("setApplicationContext   .................");
		
	}

	@Override
	public void setBeanName(String name) {
		
		System.out.println("Bean name is="+name);
		
	}

	 
	
	  
	    
}
