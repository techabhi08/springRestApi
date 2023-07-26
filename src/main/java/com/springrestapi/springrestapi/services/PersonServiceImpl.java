package com.springrestapi.springrestapi.services;

import java.util.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springrestapi.springrestapi.dao.PersonDao;
import com.springrestapi.springrestapi.entities.Person;
import com.springrestapi.springrestapi.exception.PersonNotFoundException;

/**
 * 
 * @author Abhinay Garg
 * 
 * The Service Layer Implementation class is the place where the entire core logic of application resides.
 * This layer contains some methods which are used by the controller layer to pass and retrieve info.
 * The layer is @Autowired with personDao layer to make sure that the the class dependency are injected.
 * 
 */
@Service
public class PersonServiceImpl implements PersonService {
	
//	List<Course> list;
	@Autowired
	private PersonDao personDao;
	
	public PersonServiceImpl() {
		
	}
	
	public PersonServiceImpl(PersonDao personDao) {
		this.personDao = personDao;
	}

	/*
	 * Method to retrive all the Persons from the database.
	 */
	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return personDao.findAll();
	}
	
	/*
	 * GET Operation
	 * To retrieve a all the persons from the database using given size and pageNo
	 * Pagination is implemented in this method with help of Pageable class
	 * which comes with the spring framework.
	 */
	@Override
	public List<Person> getPersons(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Person> persons = personDao.findAll(pageable);
        List<Person> listOfPersons = persons.getContent();
        return listOfPersons;
	}

	/*
	 * GET Operation - To retrieve data of a single Person with particular id /rollNo.
	 */
	@Override
	public Person getPerson(long personId) {
		Optional<Person> course = personDao.findById(personId);
		if(course.isPresent()) {
			return course.get();
		}else {
			throw new PersonNotFoundException("No person with this Roll Number is present.");
		}
	}

	/*
	 * POST Operation - Helps to insert a new Person entry to the database.
	 */
	@Override
	public Person addPerson(Person person) {
		personDao.save(person);
		return person;
	}
	
	/*
	 * Put Operation - Updates a particular data entry in the database if present,
	 * else overrides a new entry into the database.
	 */
	@Override
	public Person updatePerson(Person person) {
		personDao.save(person);
		return person;
	}

	/*
	 * DELETE Operation - Used to delete a person entry with specified rollNo / id.
	 */
	@Override
	public void deletePerson(long personId) {
		Optional<Person> course = personDao.findById(personId);
		if(course.isPresent()) {
			personDao.delete(course.get());
		}else {
			throw new PersonNotFoundException("No Person with this Roll Number exists.");
		}
	}
}
