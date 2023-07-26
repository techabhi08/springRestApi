package com.springrestapi.springrestapi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

/**
 * 
 * @author Abhinay Garg
 *
 * PersonExceptionHandler is the main Handler which is responsible for handling the exception
 * and throwing the custom error message or response back to the user.
 * Here the service layer is using the Exception class to create a new Exception which can be of type
 * PersonNotFound - which is used in put and delete function calls or
 * MethodArgumentNotValid - which is used for validation of the request input fields.
 */

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
	
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}
}
