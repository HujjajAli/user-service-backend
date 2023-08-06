package com.product.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.user.dto.ApiResponse;
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
	ResponseEntity<ApiResponse<UserDTO>> registerUser(@RequestBody UserDTO userDTO,HttpServletRequest request){
		log.info("Calling Class :UserController: Method :registerUser():");
		return userService.registerUser(userDTO,request);
	}
	
	
}
