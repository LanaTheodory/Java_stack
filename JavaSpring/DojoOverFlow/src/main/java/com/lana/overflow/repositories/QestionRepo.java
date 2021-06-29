package com.lana.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana.overflow.models.Question;
@Repository
public interface QestionRepo extends CrudRepository<Question, Long> {
List<Question> findAll();



}
