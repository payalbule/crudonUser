package com.bank.example.Banking.service;

import org.springframework.stereotype.Service;

import com.bank.example.Banking.model.User;
@Service
public interface UserService {
	public User saveUser(User user);

	

}
