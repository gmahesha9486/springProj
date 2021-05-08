package net.guides.springboot2.springboot2jpacrudexample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.model.User;
import net.guides.springboot2.springboot2jpacrudexample.service.RegistrationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registeruser")
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
		userObj.setPassword("");
		return userObj;
	}
	
	@PostMapping("/login")
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
		userObj.setPassword("");
		return userObj;
	}
}
