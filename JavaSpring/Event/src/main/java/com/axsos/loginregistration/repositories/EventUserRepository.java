package com.axsos.loginregistration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.loginregistration.models.Event;
import com.axsos.loginregistration.models.EventUser;
//three tables to joining event
@Repository
public interface EventUserRepository extends CrudRepository<EventUser, Long> {
	EventUser findByEvent(Event event);

}
