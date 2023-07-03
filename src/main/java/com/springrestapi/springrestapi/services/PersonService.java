package com.springrestapi.springrestapi.services;

import java.util.List;

import com.springrestapi.springrestapi.entities.Person;

public interface PersonService {
	
	public List<Person> getPersons();
	
	public Person getPerson(long personId);
	
	public Person addPerson(Person person);
	
	public Person updatePerson(Person person);
	
	public void deletePerson(long personId);
}
