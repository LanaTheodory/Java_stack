package com.axsos.loginregistration.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.loginregistration.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

}
