package com.bank.example.Banking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.example.Banking.Repository.UserRepository;
import com.bank.example.Banking.exception.NotFoundException;
import com.bank.example.Banking.model.User;
import com.bank.example.Banking.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Integer id) {
		 return userRepository.findById(id).orElseThrow(() -> new NotFoundException("** User not found for id :: " + id));
		
	}

	@Override
	public User updateUserById(Integer id, User user) {
		userRepository.findById(id).orElseThrow(() -> new NotFoundException("** user not found for id :: " + id));
    	user.setId(id);
		return userRepository.save(user);
	}

	@Override
	public String deleteUserById(Integer id) {
		userRepository.findById(id).ifPresent(user -> userRepository.delete(user));
		return "Deleted Successfully";
	}

}
