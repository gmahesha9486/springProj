package com.app.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		
		String tempMailId = user.getEmailId();
		if(tempMailId !=null && !"".equals(tempMailId)) {
			User userObj  = service.fetchUserByEmailId(tempMailId);
			if(userObj !=null) {
				throw new Exception("User with this mail Id is already present.");
			}
		}
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		
		String tmpEmailId = user.getEmailId();
		String tmpPass = user.getPassword();
		User userObj = null;
		
		if(tmpEmailId!=null && tmpPass!=null) {
			userObj  = service.fetchUserByEmailIdAndPassword(tmpEmailId, tmpPass);
		}
		if(userObj ==null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	}
}
