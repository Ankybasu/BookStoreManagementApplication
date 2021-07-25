package com.cg.bookstore.service;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Login;
import com.cg.bookstore.exceptions.UserNotPresentException;
import com.cg.bookstore.repository.ILoginRepository;

@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired 
	private ILoginRepository loginServiceRepo;

	
	@Override
	public String validateLogin(Login user1) {
		// TODO Auto-generated method stub
		Optional<Login> findByEmail = loginServiceRepo.findByEmailAndPassword(user1.getEmail(),user1.getPassword());
		if (findByEmail.isPresent()) {
			return "User Valid";
		} else
			throw new UserNotPresentException("User not Present");
	}
}