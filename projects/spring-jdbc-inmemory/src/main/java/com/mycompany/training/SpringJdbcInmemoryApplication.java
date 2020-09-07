package com.mycompany.training;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mycompany.training.model.Book;
import com.mycompany.training.repository.BookRepository;

@SpringBootApplication
public class SpringJdbcInmemoryApplication implements CommandLineRunner {

	 @Autowired
	 JdbcTemplate jdbcTemplate;

	 @Autowired
	 private BookRepository bookRepository;
	    
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcInmemoryApplication.class, args);
	}
	
	 @Override
	 public void run(String... args) throws Exception {
		 
	        System.out.println(("StartApplication..."));
	        runJDBC();
	 }
	 
	 void runJDBC() {

	        System.out.println("Creating tables for testing...");

	        jdbcTemplate.execute("DROP TABLE books IF EXISTS");
	        jdbcTemplate.execute("CREATE TABLE books(" +
	                "id SERIAL, name VARCHAR(255), price NUMERIC(15, 2))");

	        List<Book> books = Arrays.asList(
	                new Book("Thinking in Java", new BigDecimal("46.32")),
	                new Book("Mkyong in Java", new BigDecimal("1.99")),
	                new Book("Getting Clojure", new BigDecimal("37.3")),
	                new Book("Head First Android Development", new BigDecimal("41.19"))
	        );

	        System.out.println("[SAVE]");
	        books.forEach(book -> {
	            System.out.println("Saving...{}"+ book.getName());
	            bookRepository.save(book);
	        });

	        // count
	        System.out.println("[COUNT] Total books: {}"+ bookRepository.count());

	        // find all
	        System.out.println("[FIND_ALL] {}"+ bookRepository.findAll());

	        // find by id
	        System.out.println("[FIND_BY_ID] :2L");
	        Book book = bookRepository.findById(2L).orElseThrow(IllegalArgumentException::new);
	        System.out.println(book);

	        // find by name (like) and price
	        System.out.println("[FIND_BY_NAME_AND_PRICE] : like '%Java%' and price <= 10");
	        System.out.println(bookRepository.findByNameAndPrice("Java", new BigDecimal(10)));

	        // get name (string) by id
	        System.out.println("[GET_NAME_BY_ID] :1L = {}"+ bookRepository.getNameById(1L));

	        // update
	        System.out.println("[UPDATE] :2L :99.99");
	        book.setPrice(new BigDecimal("99.99"));
	        System.out.println("rows affected: {}"+ bookRepository.update(book));

	        // delete
	        System.out.println("[DELETE] :3L");
	        System.out.println("rows affected: {}"+ bookRepository.deleteById(3L));

	        // find all
	        System.out.println("[FIND_ALL] {}"+ bookRepository.findAll());

	    }

	 
	 
	 

}
