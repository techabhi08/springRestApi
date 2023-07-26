package com.springrestapi.springrestapi.exception;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Abhinay Garg
 * 
 * PersonException is a template class for the customized exception that is send as a response
 * to the request if something goes wrong. 
 * The class helps to send user friendly error messages along with httpStatus which 
 * helps user to find the error that occured while performing CRUD operations to the database.
 */

public class PersonException {
	private final String message;
	private final Throwable throwable;
	private final HttpStatus httpStatus;
	
	public PersonException(String message, Throwable throwable, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.throwable = throwable;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	} 
	
	
}
