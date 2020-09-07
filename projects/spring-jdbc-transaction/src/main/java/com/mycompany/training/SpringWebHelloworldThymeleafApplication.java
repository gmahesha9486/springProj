package com.mycompany.training;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class SpringWebHelloworldThymeleafApplication implements CommandLineRunner {

	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	 
	public static void main(String[] args) {
		SpringApplication.run(SpringWebHelloworldThymeleafApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(("StartApplication..."));
        runJDBC();
		
	}

	void runJDBC() {

        System.out.println("Creating tables for testing...");

        jdbcTemplate.execute("DROP TABLE books IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE books(" +
                "id SERIAL, name VARCHAR(255), price NUMERIC(15, 2))");

       
    }
	
}
