package com.springrestapi.springrestapi.exception;

/**
 * 
 * @author Abhinay Garg
 * 
 * PersonNotFound is the class who's object are created to throw the exception.
 * This is the Exception class which is given to the handler to let handler know, 
 * what kind of exception the particular method is dealing with.
 *
 */

public class PersonNotFoundException extends RuntimeException{

	public PersonNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PersonNotFoundException(String message) {
		super(message);
	}
	
}
