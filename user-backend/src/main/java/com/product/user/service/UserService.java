package com.product.user.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.product.user.dto.ApiResponse;
import com.product.user.dto.UserDTO;

public interface UserService {
	
	
	ResponseEntity<ApiResponse<UserDTO>> registerUser(UserDTO userDTO,HttpServletRequest request);

}
