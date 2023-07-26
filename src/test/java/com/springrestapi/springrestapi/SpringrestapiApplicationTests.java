package com.springrestapi.springrestapi;


import com.springrestapi.springrestapi.dao.PersonDao;

import com.springrestapi.springrestapi.entities.Person;
import com.springrestapi.springrestapi.services.PersonServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.when;

import org.assertj.core.util.Arrays;

/**
 * 
 * @author Abhinay Garg
 * 
 * This class file helps to perform the Unit Testing of the Service Layer of application.
 * The tests ensure that the service Layer functionalities are aligned correctly with the Dao Layer.
 * 
 * Mockito - This is a library which helps to mock data that is needed to be tested.
 * Assert.js - Another library helping to compare the expected and implemented result.
 *
 */
@ExtendWith(MockitoExtension.class)
class SpringrestapiApplicationTests {
	
	/*
	 * Mocking the dao layer to avoid using actual database and manipulate real time data.
	 */
	@Mock
	private PersonDao personDao;
	
	private PersonServiceImpl personService;
	
	/*
	 * The mocked dao is passes to the service layer every time before any test runs.
	 * @BeforeEach annotation helps to achieve the same.
	 */
	@BeforeEach
    void setUp() {
        this.personService = new PersonServiceImpl(this.personDao);
    }
	
	/*
	 * @Test - The annotation is used to tell Spring that these are test methods
	 * and are destined to give the success or failure results.
	 */
	@Test
	void getPersons() {
		personService.getPersons();
		verify(personDao).findAll();
	}
	
	@Test
	void getPerson() {
		personService.getPerson(20841);
		verify(personDao).findById((long) 20841);
	}
	
	@Test
	void postPerson() {
		Person person = new Person(2010101, "Abhinay", "t13@t.com", "7788992134", "Male");
		personService.addPerson(person);
		verify(personDao).save(person);
		
//		given(personDao.save(person)).willReturn(person);
//		assertThat(person.getEmail()).isEqualTo("t13@t.com");
//		assertThat(person.getName()).isEqualTo("Abhinay");
//		assertThat(person.getPhone()).isEqualTo("7788992134");
	}
	
	@Test
	void putPerson() {
		Person person = new Person(2010102, "Abhinay", "t13@t.com", "7788992134", "Male");
		personService.addPerson(person);
		
		given(personDao.save(person)).willReturn(person);
        person.setName("ram");
        person.setEmail("ram@ram.com");
        
        Person updatedPerson = personService.updatePerson(person);

        assertThat(updatedPerson.getEmail()).isEqualTo("ram@ram.com");
        assertThat(updatedPerson.getName()).isEqualTo("ram");
	}
	
	@Test
	void deletePerson() {
		long personRoll = 2010121;

        willDoNothing().given(personDao).deleteById(personRoll);
        personService.deletePerson(personRoll);

        // then - verify the output
        verify(personDao, times(1)).deleteById(personRoll);
	}
	
}
