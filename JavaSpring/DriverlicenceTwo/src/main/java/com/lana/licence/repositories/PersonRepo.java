package com.lana.licence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana.licence.models.Person;

@Repository
public interface PersonRepo  extends CrudRepository<Person, Long>{
	List<Person> findAll();
	List<Person> findByLicenseIdIsNull();
	
	

}
