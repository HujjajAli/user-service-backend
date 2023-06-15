package com.product.user.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.user.dao.UserRepository;
import com.product.user.dto.UserDTO;
import com.product.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public ResponseEntity<UserDTO> registerUser(UserDTO userDTO) {
		ResponseEntity<UserDTO> response = null;
		try {
			
		}catch (Exception e) {
			e.printStackTrace();
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		return null;
	}
}
