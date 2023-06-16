package com.product.user.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.user.dao.UserRepository;
import com.product.user.dto.UserDTO;
import com.product.user.orm.User;
import com.product.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public ResponseEntity<UserDTO> registerUser(UserDTO userDTO) {
		ResponseEntity<UserDTO> response = null;
		
		try {
			User user = new User();
			BeanUtils.copyProperties(userDTO, user);
			user = userRepository.save(user);
			userDTO.setUserId(user.getUserId());
			response = ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
			log.info("Product Added Successfully");
		}catch (Exception e) {
			e.printStackTrace();
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		return response;
	}
}
