package com.product.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.user.dto.ApiResponse;
import com.product.user.dto.RoleDTO;
import com.product.user.service.RoleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("createRole")
	public ResponseEntity<ApiResponse<RoleDTO>> saveRole(@RequestBody RoleDTO role){
		log.info("Calling Class :RoleController: + Method :saveRole():");
		return roleService.saveRole(role);
	}
	
	
	@GetMapping("getAll")
	public ResponseEntity<ApiResponse<RoleDTO>> getAllRoles(){
		log.info("Calling Class :RoleController: + Method :saveRole():");
		return roleService.getAllRoles();
	}

}
