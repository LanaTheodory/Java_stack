package com.lana.loginreg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana.loginreg.models.Attend;
@Repository
public interface AttendRepo extends CrudRepository<Attend, Long>{
	  List<Attend> findAll(); 

}
