package com.lana.licence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lana.licence.models.License;



public interface LicenceRepo extends CrudRepository<License, Long> {
	List<License> findAll();

	License findTopByOrderByNumberDesc();
}
