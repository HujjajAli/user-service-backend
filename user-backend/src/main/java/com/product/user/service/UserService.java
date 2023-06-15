package com.product.user.service;

import org.springframework.http.ResponseEntity;

import com.product.user.dto.UserDTO;

public interface UserService {
	
	
	ResponseEntity<UserDTO> registerUser(UserDTO userDTO);

}
