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

	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return personDao.findAll();
	}
	
	@Override
	public List<Person> getPersons(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Person> persons = personDao.findAll(pageable);
        List<Person> listOfPersons = persons.getContent();
        return listOfPersons;
	}

	@Override
	public Person getPerson(long personId) {
		Optional<Person> course = personDao.findById(personId);
		if(course.isPresent()) {
			return course.get();
		}else {
			throw new PersonNotFoundException("No person with this Roll Number is present.");
		}
	}

	@Override
	public Person addPerson(Person person) {
		personDao.save(person);
		return person;
	}

	@Override
	public Person updatePerson(Person person) {
		personDao.save(person);
		return person;
	}

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
