package com.lana.licence.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lana.licence.models.Contact;
import com.lana.licence.models.Student;
import com.lana.licence.repositories.ContactRepo;
import com.lana.licence.repositories.StudentRepo;

@Service
public class StudentService {
private final StudentRepo studentrepo;
private final ContactRepo contactrepo;
public StudentService( StudentRepo studentrepo , ContactRepo contactrepo) {
	this.studentrepo = studentrepo;
	this.contactrepo = contactrepo;
}

public Student createStudent(Student student) {
	return studentrepo.save(student);
}

public List<Student> allStudents(){
	return studentrepo.findAll();
}
public Contact createContact (Contact  contact) {
	return contactrepo.save(contact);
}

public List<Contact > allContacts(){
	return contactrepo.findAll();
}



}
