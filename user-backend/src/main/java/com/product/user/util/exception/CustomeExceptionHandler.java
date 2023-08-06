package com.product.user.util.exception;

import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import com.product.user.dto.ApiError;



@ControllerAdvice
public class CustomeExceptionHandler {
	
	@ExceptionHandler({UserDataValidationException.class})
	@ResponseBody
	public ResponseEntity<ApiError> userDataValidationExceptionandler(Exception e,ServletWebRequest request){
		ApiError error = new ApiError();
		error.setPathUri(request.getDescription(true));
		error.setStatus(HttpStatus.BAD_REQUEST);
		error.setErrors(Arrays.asList(e.getMessage()));
		return new ResponseEntity(error,new HttpHeaders(),error.getStatus());	
	}

}
