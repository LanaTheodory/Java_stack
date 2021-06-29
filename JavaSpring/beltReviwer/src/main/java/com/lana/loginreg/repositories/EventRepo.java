package com.lana.loginreg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana.loginreg.models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long>{
  List<Event> findAll();
  
}
