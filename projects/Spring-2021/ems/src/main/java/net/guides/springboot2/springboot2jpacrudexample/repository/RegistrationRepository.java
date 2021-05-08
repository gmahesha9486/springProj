package net.guides.springboot2.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.guides.springboot2.springboot2jpacrudexample.model.User;

public interface RegistrationRepository extends JpaRepository<User, Integer> {

	public User findByEmailId(String emailId);
	
	public User findByEmailIdAndPassword(String emailId, String password);
}
