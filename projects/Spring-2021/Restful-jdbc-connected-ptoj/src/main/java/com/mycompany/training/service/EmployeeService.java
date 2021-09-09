package com.mycompany.training.service;

import java.util.List;

import com.mycompany.training.model.Student;
import com.mycompany.training.model.User;


public interface EmployeeService {

	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);

	List<User> findAllUsers();
	
	void deleteAllUsers();
	
	boolean isUserExist(User user);
	public void test();
	
	List<Student> findAllStudents();
	Student findStudentById(int id); 
	public boolean isStudentExist(Student stud);
	void saveStudent(Student user);
	public void updateStudent(Student student);
	
	public void deleteStudentById(long id);
	
}
