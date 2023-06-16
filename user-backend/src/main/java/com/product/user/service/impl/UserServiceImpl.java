package com.product.user.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.user.dao.UserRepository;
import com.product.user.dto.UserDTO;
import com.product.user.orm.UserEntity;
import com.product.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<UserDTO> registerUser(UserDTO userDTO) {
		ResponseEntity<UserDTO> response = null;
		
		if(userDTO.getEmail() == null || userDTO.getEmail().isEmpty()) {
			throw new UserDataValidationException("some email error throw");
		}
		
		try {
			UserEntity user = new UserEntity();
			BeanUtils.copyProperties(userDTO, user);
			user = userRepository.save(user);
			userDTO.setUserId(user.getUserId());
			response = ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
			log.info("User Created Successfully");
		}catch (Exception e) {
			e.printStackTrace();
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
		return response;
	}
}
