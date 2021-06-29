package com.lana.overflow.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.lana.overflow.models.QuestionTag;
@Repository
public interface QuestionTagRepo extends CrudRepository<QuestionTag, Long> {


}
