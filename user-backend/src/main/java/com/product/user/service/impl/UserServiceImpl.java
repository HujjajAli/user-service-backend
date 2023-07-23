package com.product.user.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.product.user.dao.UserRepository;
import com.product.user.dto.UserDTO;
import com.product.user.orm.UserEntity;
import com.product.user.service.UserService;
import com.product.user.util.validator.UserValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordService passwordService;


	@Override
	public ResponseEntity<?> registerUser(UserDTO userDTO,HttpServletRequest request) {
		ResponseEntity<?> response = null;
		/*if(userDTO.getEmail() == null || userDTO.getEmail().isEmpty()) {
			throw new UserDataValidationException("some email error throw");
		}*/
		Object[] arrayValue = UserValidator.validate(userDTO, request, response);
		if((boolean)arrayValue[0]){
			return (ResponseEntity<?>)arrayValue[1];
		}else {
			try {
				UserEntity user = new UserEntity();
				userDTO.setPassword(passwordService.securePassword(userDTO.getPassword()));
				BeanUtils.copyProperties(userDTO, user);
				
				//user = userRepository.save(user);
				userDTO.setUserId(user.getUserId());
				response = ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
				log.info("User Created Successfully");
			}catch (Exception e) {
				e.printStackTrace();
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
			}
		}
		return response;
	}
}
