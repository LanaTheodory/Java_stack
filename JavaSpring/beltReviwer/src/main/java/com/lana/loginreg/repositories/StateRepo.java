package com.lana.loginreg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana.loginreg.models.State;
@Repository
public interface StateRepo extends CrudRepository<State, Long>{
	  List<State> findAll(); 
}
