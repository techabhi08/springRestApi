package com.springrestapi.springrestapi.services;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.springrestapi.dao.PersonDao;
import com.springrestapi.springrestapi.entities.Person;

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
	public Person getPerson(long personId) {
		Optional<Person> course = personDao.findById(personId);
		if(course.isPresent()) {
			return course.get();
		}
		return null;
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
		personDao.delete(course.get());
	}

}
