package com.ecommerce.exceptionhandling;

public class ProductAlreadyExistException extends RuntimeException {
	
	public ProductAlreadyExistException(String msg) {
		super(msg);
	}

}
