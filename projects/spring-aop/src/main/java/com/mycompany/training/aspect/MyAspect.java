package com.mycompany.training.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	/** Following is the definition for a PointCut to select
	    *  all the methods available in the package: com.mycompany.training.controller
	    *  for all the methods.
	    */
	   @Pointcut("execution(* com.mycompany.training.controller.*.*(..))")
	   private void selectAll(){}

	   @Pointcut("execution(* com.mycompany.training.service.*.*(..))")
	   private void serviceMethods(){}
	   
	   /** 
	    * This is the method which I would like to execute
	    * before a selected method execution.
	    */
	   @Before("selectAll()")
	   public void beforeAdvice(){
	      System.out.println("beforeAdvice method has been called.");
	   } 
	   
	   @After("selectAll()")
	   public void afterAdvice(){
	      System.out.println("afterAdvice method has been called.");
	   } 
	   
	   @Before("serviceMethods()")
	   public void beforeAdviceForService(JoinPoint point){
	      System.out.println("Before method:" + point.getSignature()); 
	      
	   } 
	   
	   
}
