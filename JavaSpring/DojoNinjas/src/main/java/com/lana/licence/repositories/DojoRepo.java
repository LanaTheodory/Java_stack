package com.lana.licence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana.licence.models.Dojo;
@Repository
public interface DojoRepo  extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();

}
