package com.cg.bookstore.service;

import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Login;

@Service
public interface ILoginService {
	public String validateLogin(Login user1);
}