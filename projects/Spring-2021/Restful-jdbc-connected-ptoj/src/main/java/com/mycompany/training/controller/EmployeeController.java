package com.mycompany.training.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mycompany.training.model.Student;
import com.mycompany.training.model.User;
import com.mycompany.training.service.EmployeeService;
import com.mycompany.training.util.CustomErrorType;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService userService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Users---------------------------------------------

		@RequestMapping(value = "/user/", method = RequestMethod.GET)
		public ResponseEntity<List<User>> listAllUsers() {
			List<User> users = userService.findAllUsers();
			if (users.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/student/", method = RequestMethod.GET)
		public ResponseEntity<List<Student>> listAllStudents() {
			List<Student> students = userService.findAllStudents();
			if (students.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		}
		
		// -------------------Retrieve Single User------------------------------------------

		@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> getUser(@PathVariable("id") long id) {
			logger.info("Fetching User with id {}", id);
			User user = userService.findById(id);
			if (user == null) {
				logger.error("User with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("User with id " + id 
						+ " not found"), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
		public ResponseEntity<?> getStudent(@PathVariable("id") int id) {
			logger.info("Fetching User with id {}", id);
			Student stud = userService.findStudentById(id);
			if (stud == null) {
				logger.error("User with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("User with id " + id 
						+ " not found"), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Student>(stud, HttpStatus.OK);
		}

		// -------------------Create a User-------------------------------------------

		@RequestMapping(value = "/user/", method = RequestMethod.POST)
		public ResponseEntity<?> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
			logger.info("Creating User : {}", user);

			if (userService.isUserExist(user)) {
				logger.error("Unable to create. A User with name {} already exist", user.getName());
				return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
				user.getName() + " already exist."),HttpStatus.CONFLICT);
			}
			userService.saveUser(user);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
		
		@RequestMapping(value = "/student/", method = RequestMethod.POST)
		public ResponseEntity<?> createStudent(@RequestBody Student stud, UriComponentsBuilder ucBuilder) {
			logger.info("Creating Student ................ : {}", stud);
			int studId = stud.getId().intValue();
			logger.info("-------------------1");
			boolean isStudExists = userService.isStudentExist(stud);
			logger.info("-------------------2");
			if (!isStudExists){
				userService.saveStudent(stud);
				logger.info(" ============= If ================= ");
				
			}else {
				logger.info("Inside else===========");
				logger.error("Unable to create. A Student with name {} already exist", stud.getName());
				return new ResponseEntity(new CustomErrorType("Unable to create. A Student with name " + 
				stud.getName() + " already exist."),HttpStatus.CONFLICT);
			}	

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/student/{id}").buildAndExpand(stud.getId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}

		// ------------------- Update a User ------------------------------------------------

		@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
			logger.info("Updating User with id {}", id);

			User currentUser = userService.findById(id);

			if (currentUser == null) {
				logger.error("Unable to update. User with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}

			currentUser.setName(user.getName());
			currentUser.setAge(user.getAge());
			currentUser.setSalary(user.getSalary());

			userService.updateUser(currentUser);
			return new ResponseEntity<User>(currentUser, HttpStatus.OK);
		}
		
		@RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> updateStudent(@PathVariable("id") long id, @RequestBody Student stud) {
			logger.info("Updating Student with id {}", id);

			int studId = (int)id;
			Student currentUser = userService.findStudentById(studId);

			if (currentUser == null) {
				logger.error("Unable to update. Student with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Unable to upate. Student with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}

			currentUser.setName(stud.getName());
			currentUser.setId(id);
			currentUser.setPassportNumber(stud.getPassportNumber());

			userService.updateStudent(currentUser);
			return new ResponseEntity<Student>(currentUser, HttpStatus.OK);
		}

		// ------------------- Delete a User-----------------------------------------

		@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
			logger.info("Fetching & Deleting User with id {}", id);

			User user = userService.findById(id);
			if (user == null) {
				logger.error("Unable to delete. User with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}
			userService.deleteUserById(id);
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		
		@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteStudent(@PathVariable("id") long id) {
			logger.info("Fetching & Deleting User with id {}", id);

			int studId = (int)id;
			Student user = userService.findStudentById(studId);
			if (user == null) {
				logger.error("Unable to delete. Student with id {} not found.", id);
				return new ResponseEntity(new CustomErrorType("Unable to delete. Student with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}
			userService.deleteStudentById(id);
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}

		// ------------------- Delete All Users-----------------------------

		@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
		public ResponseEntity<User> deleteAllUsers() {
			logger.info("Deleting All Users");

			userService.deleteAllUsers();
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}

	
}
