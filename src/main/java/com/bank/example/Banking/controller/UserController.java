package com.bank.example.Banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.example.Banking.model.User;
import com.bank.example.Banking.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "User API", name = "User Services")
@RestController
public class UserController {
	@Autowired(required = true)
    private UserService userService;

    @PostMapping("/user")
    @Operation(summary = "Register a new user")
    public User saveEmployee(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
