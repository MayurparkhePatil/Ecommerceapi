package com.ecommerce.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(ProductAlreadyExistException.class)
	public ResponseEntity<String>productAlreadyExistException(ProductAlreadyExistException msg){
		String message = msg.getMessage();
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> productNotFoundException(ProductNotFoundException pnf){
		String msg = pnf.getMessage();
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
}
