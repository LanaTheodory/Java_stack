package com.lana.licence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana.licence.models.Contact;

@Repository
public interface ContactRepo extends CrudRepository<Contact, Long> {
	List<Contact> findAll();
	
	

}
