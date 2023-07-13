package com.springrestapi.springrestapi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

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
