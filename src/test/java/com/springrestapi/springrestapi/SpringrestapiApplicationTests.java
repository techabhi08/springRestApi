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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.util.Arrays;

@ExtendWith(MockitoExtension.class)
class SpringrestapiApplicationTests {
	
	@Mock
	private PersonDao personDao;
	
	private PersonServiceImpl personService;
	
	@BeforeEach
    void setUp() {
        this.personService = new PersonServiceImpl(this.personDao);
    }
	
	@Test
	void getCourses() {
		personService.getPersons();
		verify(personDao).findAll();
//		when(personDao.findAll()).thenReturn(Arrays.asList(new Person("Abhi", "BCE", "test@test.com", "8878798082", "Male"), new Person("Mayank", "BAI", "test2@test.com", "8878798082", "Male")));
	}
}
