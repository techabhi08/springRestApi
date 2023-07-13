package com.springrestapi.springrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PersonExceptionHandler {
	
	@ExceptionHandler(value = {PersonNotFoundException.class})
	public ResponseEntity<Object> handlePersonNotFoundException
	(PersonNotFoundException personNotFoundException){
		PersonException personException = 
				new PersonException(personNotFoundException.getMessage(),
						personNotFoundException.getCause(),
								HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(personException, HttpStatus.NOT_FOUND);
	}
}
