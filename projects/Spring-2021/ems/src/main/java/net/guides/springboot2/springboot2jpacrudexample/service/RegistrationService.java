package net.guides.springboot2.springboot2jpacrudexample.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.guides.springboot2.springboot2jpacrudexample.model.User;
import net.guides.springboot2.springboot2jpacrudexample.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}

	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return repo.findByEmailIdAndPassword(email, password);
		
	}
	
}