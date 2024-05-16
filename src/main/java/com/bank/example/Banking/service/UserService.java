package com.bank.example.Banking.service;

import org.springframework.stereotype.Service;

import com.bank.example.Banking.model.User;
@Service
public interface UserService {
	public User saveUser(User user);
	public User getUserById(Integer id);
    public User updateUserById(Integer id, User user);
    public String deleteUserById(Integer id);
	

	

}
