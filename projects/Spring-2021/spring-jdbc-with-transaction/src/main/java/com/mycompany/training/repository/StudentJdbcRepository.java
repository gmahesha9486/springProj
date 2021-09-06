package com.mycompany.training.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.training.model.Student;

@Repository
public class StudentJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int getRecordCount() {
		
		int count = jdbcTemplate.queryForObject("select count(*) from student", Integer.class);
		return count;
		
	}
	
	public Student findByID(int id) {
		
		return jdbcTemplate.queryForObject("select * from student where id = ?", new Object[]{id},
				new BeanPropertyRowMapper<Student>(Student.class));	
				
	}
	
	public List<Student> findAll() {
		return jdbcTemplate.query("select * from student", new StudentRowMapper());
	}
	
	public int deleteById(long id) {
		return jdbcTemplate.update("delete from student where id=?", new Object[] { id });
	}

	@Transactional
	public int insert(Student student) {
		 if(student.getName().equals("test")) { System.out.println(" Introducing some error ............");
			return jdbcTemplate.update("insert into student (id, name) " + "values(?,  ?,?, ?)",
					new Object[] { student.getId(), student.getName(), student.getPassportNumber() });
		}else 
			return jdbcTemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
				new Object[] { student.getId(), student.getName(), student.getPassportNumber() });
	}

	public int update(Student student) {
		return jdbcTemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
				new Object[] { student.getName(), student.getPassportNumber(), student.getId() });
	}

	
}
