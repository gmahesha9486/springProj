package com.mycompany.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Bootstrap implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;
	 
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(("StartApplication..."));
		runJDBC();
		
	}
	
	public void runJDBC() {
		
		 System.out.println("Creating tables for testing...");

	        jdbcTemplate.execute("DROP TABLE student IF EXISTS");
	        jdbcTemplate.execute("CREATE TABLE student(" +
	                "id integer not null, name VARCHAR(255),passport_number varchar(255) not null,primary key(id))");
	        
	        jdbcTemplate.execute("insert into student values(10001,'Mahesh', 'E1234567')");
	        jdbcTemplate.execute("insert into student values(10002,'Manoj', 'A1234568')");
	        
	}

}
