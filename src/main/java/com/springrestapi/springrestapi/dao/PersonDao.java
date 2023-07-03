package com.springrestapi.springrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.springrestapi.entities.Person;


public interface PersonDao extends JpaRepository<Person, Long>{

}
