package com.springrestapi.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.springrestapi.entities.Person;
import com.springrestapi.springrestapi.services.PersonService;

import jakarta.validation.Valid;

/**
 * @author Abhinay Garg
 * 
 * The controller class is implemented to handle the API request calls 
 * and further the calls are processed by passing the calls to service layer using methods.
 * 
 * CrossOrigin ("*") - Allows request from all the URLs, 
 * helps to avoid the CORS error when trying to access from different host, localhost:4200 in this case.
 * 
 * @RequestMapping is used to make sure that all the API calls are routed through /persons.
**/

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/persons")
public class MyController {
	
	/** 
	 * Including the person service, to work with core logic. 
	 **/
	
	@Autowired
	private PersonService personService;
	
	/**
	 * Mappings using the Annotations(@) to handle the API calls from the client.
	 * GetMapping - Used to fetch data from backend
	 * PostMapping - used to insert Person data into data base
	 * PutMapping - used to Update the Person data
	 * DeleteMapping - used to delete a particular person
	 **/
	
	@GetMapping("")
	public List<Person> getPerson(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "100", required = false) int pageSize){
		return this.personService.getPersons(pageNo, pageSize);
	}
	
	@GetMapping("/{personId}")
	public Person getPerson(@PathVariable String personId){
		return this.personService.getPerson(Long.parseLong(personId));
	}
	
	@PostMapping("")
	public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
		return new ResponseEntity<>(this.personService.addPerson(person), HttpStatus.CREATED);
	}
	
	
	@PutMapping("")
	public Person editPerson(@Valid @RequestBody Person person) {
		return this.personService.updatePerson(person);
	}
	
	@DeleteMapping("/{personId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String personId) {
		try {
			this.personService.deletePerson(Long.parseLong(personId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			throw e;
		}
	}
}
