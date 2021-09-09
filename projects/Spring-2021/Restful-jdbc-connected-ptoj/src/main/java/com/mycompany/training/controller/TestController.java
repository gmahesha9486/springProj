package com.mycompany.training.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.training.model.Student;
import com.mycompany.training.repository.StudentJdbcRepository; 


@Controller
public class TestController {

	@Autowired
	StudentJdbcRepository obj;
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Transactional
	 public void doSomeStuff() {
		  	
			System.out.println("Count = "+obj.getRecordCount());
			logger.info("Count = {}", obj.getRecordCount());
			
			//Student student = obj.findByID(10002);
			//System.out.println(student.getName());
		
//			System.out.println(obj.findAll());
			
			

			System.out.println("Update 10001 -> {}"+ obj.update(new Student(10001L, "Name-Updated", "New-Passport")));

			obj.deleteById(10002L);

			logger.info("Inserting one record");
			System.out.println("Inserting -> {}"+ obj.insert(new Student(10010L, "John", "A1234657")));
			
			logger.info("Inserting one more record");
			System.out.println("Inserting -> {}"+ obj.insert(new Student(10011L, "Suresh","A1234657")));
			 
			logger.info("Display all records");
			System.out.println("All users  -> {}"+ obj.findAll());
			
	 }
	 
	 
	 @Transactional
	 public void addRecords() {
		 
		
	 }
}
