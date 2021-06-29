package com.lana.overflow.services;

import org.springframework.stereotype.Service;

import com.lana.overflow.repositories.AnswerRepo;
import com.lana.overflow.repositories.QestionRepo;
import com.lana.overflow.repositories.QuestionTagRepo;
import com.lana.overflow.repositories.TagRepo;

@Service
public class AppService {
private final QuestionTagRepo qtRepo;
private final QestionRepo qRepo;
private final TagRepo tRepo;
private final AnswerRepo aRepo;

public AppService(QuestionTagRepo qtRepo, QestionRepo qRepo, TagRepo tRepo, AnswerRepo aRepo) {
	
	this.qtRepo = qtRepo;
	this.qRepo = qRepo;
	this.tRepo = tRepo;
	this.aRepo = aRepo;
}

//public Question 


}
