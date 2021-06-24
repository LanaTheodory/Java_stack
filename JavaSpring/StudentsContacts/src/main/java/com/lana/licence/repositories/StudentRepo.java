package com.lana.licence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana.licence.models.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long>{
	List<Student> findAll();
	List<Student> findByContactIdIsNull();

}
