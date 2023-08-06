package com.product.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.user.dao.RoleRepository;
import com.product.user.dao.UserRepository;
import com.product.user.dto.ApiResponse;
import com.product.user.dto.RoleDTO;
import com.product.user.dto.UserDTO;
import com.product.user.orm.RoleEntity;
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
	@Autowired
	private RoleRepository roleRepository;


	@Override
	public ResponseEntity<ApiResponse<UserDTO>> registerUser(UserDTO userDTO,HttpServletRequest request) {
		ResponseEntity<ApiResponse<UserDTO>> response = null;
		ApiResponse<UserDTO> apiResponse = new ApiResponse<UserDTO>();
		Object[] arrayValue = UserValidator.validate(userDTO, request);
		if((boolean)arrayValue[0]){
			apiResponse.setStatus(HttpStatus.BAD_REQUEST);
			apiResponse.setMessage("Validation Failed for User");
			return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}else {
			try {
				List<RoleEntity> roles = new ArrayList<RoleEntity>();
				UserEntity user = new UserEntity();
				userDTO.setPassword(passwordService.securePassword(userDTO.getPassword()));
				BeanUtils.copyProperties(userDTO, user);
				
				for(RoleDTO roleDto:userDTO.getRoles()) {
					RoleEntity role = roleRepository.findByRoleCode(roleDto.getRoleCode());
					roles.add(role);
				}
				user.setRoles(roles);
				
				//user = userRepository.save(user);
				userDTO.setUserId(user.getUserId());
				apiResponse.setStatus(HttpStatus.BAD_REQUEST);
				apiResponse.setMessage("User Registred Successfully");
				apiResponse.setData(Arrays.asList(userDTO));
				
				log.info("User Created Successfully");
				return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
				
			}catch (Exception e) {
				e.printStackTrace();
				apiResponse.setMessage(e.getMessage());
				apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
				return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
			}
		}
	}
}
