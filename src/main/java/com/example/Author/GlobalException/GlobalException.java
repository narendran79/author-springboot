package com.example.Author.GlobalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Author.Exception.ResourceNotFound;


@RestControllerAdvice
public class GlobalException {

	@Autowired
	private ApiError error;
	
	@ExceptionHandler(value = ResourceNotFound.class)
	public ResponseEntity<ApiError> emptyInputException(){
		error.setError(" authorId you're looking for is not available");
		return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
	}
}
