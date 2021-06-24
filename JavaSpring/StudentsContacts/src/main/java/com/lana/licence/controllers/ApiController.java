package com.lana.licence.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lana.licence.models.Contact;
import com.lana.licence.models.Student;
import com.lana.licence.services.StudentService;

@Controller
public class ApiController {
	private final StudentService studentservice;
	public ApiController (StudentService studentservice) {
		this.studentservice = studentservice;
	}
	
@RequestMapping("/students")	
public String students(Model model) {
	model.addAttribute("student",studentservice.allStudents());
	return "index.jsp";
}

@RequestMapping("/student/new")
public String newString (@ModelAttribute("students") Student strudent) {
	return "newStudent.jsp";
}

@PostMapping("student/new")
public String createStudent(@Valid @ModelAttribute("students") Student student,BindingResult result ) {
	if(result.hasErrors()) {
		return "newStudent.jsp";
	}
	studentservice.createStudent(student);
	
	return "redirect:/students";
}


@PostMapping("contact/new")
public String createContact(@Valid @ModelAttribute("contacts") Contact contact,BindingResult result ) {
	if(result.hasErrors()) {
		return "newContact.jsp";
	}
	studentservice.createContact(contact);
	
	return "redirect:/contacts";
}




}
