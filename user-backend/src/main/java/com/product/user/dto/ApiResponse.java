package com.product.user.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiResponse<T> {
	
	private String message;
	private HttpStatus status;
	private List<T> data;

}
