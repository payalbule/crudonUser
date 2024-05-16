package com.bank.example.Banking.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.example.Banking.model.User;
import com.bank.example.Banking.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "User API", name = "User Services")
@RestController
public class UserController {
	@Autowired(required = true)
    private UserService userService;

    @PostMapping("/user")
    @Operation(summary = "Register a new user")
    public ResponseEntity<User> saveEmployee(@RequestBody User user) {
       User userModel = userService.saveUser(user);
       return new ResponseEntity<>(userModel,HttpStatus.OK);
    }
    
    @GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
			User user = userService.getUserById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			User user = userService.getUserById(id);
			userService.deleteUserById(id);
			map.put("status", 1);
			map.put("message", "Record is deleted successfully!");
			return new ResponseEntity<>(map, HttpStatus.OK);
		} catch (Exception ex) {
			map.clear();
			map.put("status", 0);
			map.put("message", "Data is not found");
			return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	}
    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userService.updateUserById(id, user);
        return ResponseEntity.ok().body(updatedUser);
    }
}
