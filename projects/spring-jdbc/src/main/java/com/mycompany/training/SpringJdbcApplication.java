package com.mycompany.training;

import java.util.List;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mycompany.training.dao.EmployeeDAO;
import com.mycompany.training.model.Employee;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		
		ApplicationContext context =  SpringApplication.run(SpringJdbcApplication.class, args);
		
		//Get the EmployeeDAO Bean
				EmployeeDAO employeeDAO = context.getBean("employeeDAO", EmployeeDAO.class);
				
				//Run some tests for JDBC CRUD operations
				Employee emp = new Employee();
				int rand = new Random().nextInt(1000);
				emp.setId(rand);
				emp.setName("Pankaj");
				emp.setRole("Java Developer");
				
				//Create
				employeeDAO.save(emp);
				
				//Read
				Employee emp1 = employeeDAO.getById(rand);
				System.out.println("Employee Retrieved::"+emp1);
				
				//Update
				emp.setRole("CEO");
				employeeDAO.update(emp);
				
				//Get All
				List<Employee> empList = employeeDAO.getAll();
				System.out.println(empList);
				
				//Delete
				employeeDAO.deleteById(rand);
				 	
				System.out.println("DONE");
		
	}

}
