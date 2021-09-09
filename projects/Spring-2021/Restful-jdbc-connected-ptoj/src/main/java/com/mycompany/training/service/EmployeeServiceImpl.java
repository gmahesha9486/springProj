package com.mycompany.training.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.training.controller.TestController;
import com.mycompany.training.model.Student;
import com.mycompany.training.model.User;
import com.mycompany.training.repository.StudentJdbcRepository;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	StudentJdbcRepository obj;
	
	@Autowired
	TestController test;
	
private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<Student> findAllStudents(){
		List<Student>students = null;
		students = obj.findAll();
		return students;
	}
	
	public List<User> findAllUsers() {
		
		//System.out.println("Update 10001 -> {}"+ obj.update(new Student(10001L, "Name-test", "New-Passport")));
		test.doSomeStuff();
		return users;
	}
	public void test() {
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiii");
	}
	
	public Student findStudentById(int id) {
		Student student = obj.findByID(id); 
		return student;
	}
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public void saveStudent(Student student) {
		 obj.insert(student);
	}
	public void saveUser(User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void updateStudent(Student student) {
		obj.update(student);
	}
	
	public void deleteStudentById(long id) {
		obj.deleteById(id);
	}
	public void deleteUserById(long id) {
		
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

//	public boolean isStudentExist(Student stud) {
//		return findStudentById(stud.getId().intValue())!=null;
//	}
	public boolean isStudentExist(Student stud) {
		int count = obj.isStudentExists(stud.getId().intValue());
		if(count>1)
			return true;
		return false;
		
	}
	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	public void deleteAllUsers(){
		users.clear();
	}

	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"Sam",30, 70000));
		users.add(new User(counter.incrementAndGet(),"Tom",40, 50000));
		users.add(new User(counter.incrementAndGet(),"Jerome",45, 30000));
		users.add(new User(counter.incrementAndGet(),"Silvia",50, 40000));
		return users;
	}

	 
}
