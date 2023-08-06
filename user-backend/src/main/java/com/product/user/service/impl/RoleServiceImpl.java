package com.product.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.user.dao.RoleRepository;
import com.product.user.dto.ApiResponse;
import com.product.user.dto.RoleDTO;
import com.product.user.orm.RoleEntity;
import com.product.user.service.RoleService;
import com.product.user.util.Util;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ResponseEntity<ApiResponse<RoleDTO>> saveRole(RoleDTO roleDto) {
		ResponseEntity<ApiResponse<RoleDTO>> response = null;
		ApiResponse<RoleDTO> apiResponse = new ApiResponse<RoleDTO>();
		try {
			RoleEntity roleEntity = new RoleEntity();
			BeanUtils.copyProperties(roleDto, roleEntity);
			roleRepository.save(roleEntity);
			roleDto.setRoleId(roleEntity.getRoleId());
			
			apiResponse.setMessage("Role Created Succesfully");
			apiResponse.setStatus(HttpStatus.OK);
			apiResponse.setData(Arrays.asList(roleDto));
			response = ResponseEntity.ok(apiResponse);
		}catch (Exception e) {
			e.printStackTrace();
			apiResponse.setMessage(e.getMessage());
			apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response = ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		}
		
		return response;
	}

	@Override
	public ResponseEntity<ApiResponse<RoleDTO>> getAllRoles() {
		ApiResponse<RoleDTO> apiResponse = new ApiResponse<RoleDTO>();
	try{
		List<RoleEntity> getAllRoles = roleRepository.findAll();
		List<RoleDTO> roleData = new ArrayList<RoleDTO>();
		for(RoleEntity roleEntity:getAllRoles) {
			RoleDTO roleDto = new RoleDTO();
			BeanUtils.copyProperties(roleEntity, roleDto);
			roleData.add(roleDto);	
		}
		apiResponse.setMessage("SUCCESS");
		apiResponse.setStatus(HttpStatus.OK);
		apiResponse.setData(roleData);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}catch (Exception e) {
		e.printStackTrace();
		apiResponse.setMessage(e.getMessage());
		apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	}

}
