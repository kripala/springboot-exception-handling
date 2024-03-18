package com.demo.exceptions.global;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String message) {
		
		super(message);
	}

}
