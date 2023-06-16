package com.product.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.user.dto.UserDTO;
import com.product.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/profile")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
		log.info("Calling Register User");
		return userService.registerUser(userDTO);
	}
	
	
}
