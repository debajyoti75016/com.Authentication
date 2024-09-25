package com.authentication.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authentication.Repository.UserRepository;
import com.authentication.entities.User;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository repo;
public boolean usernameExists(String username) {
		User user =repo.findByUsername(username);
		if(user!=null) {
			return true;
		}
		else {
			return false;
		}
	}
public void addUser(User user) {
		repo.save(user);
		
	}
   @Override
	public boolean validateUser(String username, String password) {
	if(usernameExists(username)) {
		//password= database password =>true
		User user= repo.findByUsername(username);
		String dbpass=user.getPassword();
		if(password.equals(dbpass)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	else {
		return false;
	}
	
	}
}
