package com.product.user.service;

import org.springframework.http.ResponseEntity;

import com.product.user.dto.ApiResponse;
import com.product.user.dto.RoleDTO;

public interface RoleService {
	
	
	public ResponseEntity<ApiResponse<RoleDTO>> saveRole(RoleDTO roleDto);
	public ResponseEntity<ApiResponse<RoleDTO>> getAllRoles();

}
