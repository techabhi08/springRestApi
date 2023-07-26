package com.springrestapi.springrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.springrestapi.entities.Person;

/**
 * 
 * @author Abhinay Garg
 * 
 * Dao Repository is particularly a JPA specific extension for Repository. 
 * It has full API CrudRepository and PagingAndSortingRepository. 
 * So, basically, it contains the APIs for basic CRUD operations, the APIs for pagination, and sorting.
 * 
 * Acts as layer between Service Layer and Database.
 */
public interface PersonDao extends JpaRepository<Person, Long>{

}
