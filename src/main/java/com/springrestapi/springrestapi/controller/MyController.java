package com.springrestapi.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.springrestapi.entities.Person;
import com.springrestapi.springrestapi.services.PersonService;

@RestController
public class MyController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/persons")
	public List<Person> getPersons(){
		return this.personService.getPersons();
	}
	
	@GetMapping("/persons/{personId}")
	public Person getPerson(@PathVariable String personId){
		return this.personService.getPerson(Long.parseLong(personId));
	}
	
	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person person) {
		return this.personService.addPerson(person);
	}
	
	@PutMapping("/persons")
	public Person editPerson(@RequestBody Person person) {
		return this.personService.updatePerson(person);
	}
	
	@DeleteMapping("/persons/{personId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String personId) {
		try {
			this.personService.deletePerson(Long.parseLong(personId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}