package com.lana.lang.repositories;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lana.lang.models.Language;

@Repository
public interface languageRepo extends CrudRepository<Language, Long> {

	List<Language> findAll();

}
