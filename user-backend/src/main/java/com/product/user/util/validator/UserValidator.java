package com.product.user.util.validator;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.product.user.dto.ApiError;
import com.product.user.dto.UserDTO;
import com.product.user.util.exception.UserDataValidationException;

public class UserValidator {
	
	
	public static Object[] validate(UserDTO userDTO,HttpServletRequest request,ResponseEntity<?> response) {
		Object[] responseObj = new Object[2]; 
		ApiError errors = new ApiError();
		List<String> listOfErrors = new ArrayList<String>();
		if(userDTO.getEmail() == null || userDTO.getEmail().isEmpty()) {
			listOfErrors.add("Please Enter Email Address");
		}
		
		if(userDTO.getName() == null || userDTO.getName().isEmpty()) {
			listOfErrors.add("Please Enter Name");
		}
		
		if(userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
			listOfErrors.add("Please Enter Password");
		}
		
		if(userDTO.getMobileNumber() == null || userDTO.getMobileNumber().isEmpty()) {
			listOfErrors.add("Please Enter Mobile Number");
		}
		
		errors.setErrors(listOfErrors);
		errors.setPathUri(request.getRequestURI());
		errors.setStatus(HttpStatus.BAD_REQUEST);
		
		
		if(errors.getErrors() != null && errors.getErrors().size() > 0) {
			response = ResponseEntity.status(errors.getStatus()).body(errors);
			responseObj[0] = true;
			responseObj[1] = response;
			return responseObj;
		}else {
			responseObj[0] = false;
			return responseObj;
		}
	}

}
