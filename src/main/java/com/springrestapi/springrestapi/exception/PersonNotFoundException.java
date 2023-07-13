package com.springrestapi.springrestapi.exception;

public class PersonNotFoundException extends RuntimeException{

	public PersonNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonNotFoundException(String message) {
		super(message);
	}
	
}
