package com.lana.overflow.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name="tags_questions")
public class QuestionTag {
		

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="tag_id")
 private Tag tag;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="question_id")
 private Question question;
 

 
public QuestionTag() {
	super();
}

public QuestionTag(Tag tag, Question question) {
	super();
	this.tag = tag;
	this.question = question;
}

public Tag getTag() {
	return tag;
}

public void setTag(Tag tag) {
	this.tag = tag;
}

public Question getQuestion() {
	return question;
}

public void setQuestion(Question question) {
	this.question = question;
}

@PrePersist
protected void onCreate() {
	this.createdAt = new Date();
}

@PreUpdate
protected void onUpdate() {
	this.updatedAt = new Date();
}

}



