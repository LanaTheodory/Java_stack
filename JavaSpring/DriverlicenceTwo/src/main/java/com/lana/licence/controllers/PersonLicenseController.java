package com.lana.licence.controllers;


import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.lana.licence.models.License;
import com.lana.licence.models.Person;
import com.lana.licence.services.PersonService;

@Controller
public class PersonLicenseController {
	private final PersonService servicePL;
	public PersonLicenseController(PersonService servicePL) {
		this.servicePL = servicePL;
	}
	
	@RequestMapping("/")
	public String people(@ModelAttribute("person") Person person) {
		
		return "index.jsp";
	}
	
	@PostMapping("/person/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
		return "index.jsp";
		} else
			servicePL.createPerson(person);
			return "redirect:/license";
			
	}
	@RequestMapping("/license")
	public String license(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("people", servicePL.allPeople());
		
		return "license.jsp";
	}
	
	@PostMapping("/license/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result){
		if(result.hasErrors()) {
		return "license.jsp";
		} else		
			servicePL.createLicense(license);
			return "redirect:/profile/" + license.getPerson().getId();
	}
	
	
	@RequestMapping("/profile/{id}")
	public String profile(Model model, @PathVariable("id") Long id) {
		model.addAttribute("person", servicePL.findPerson(id));
		return "profile.jsp";
	}
}
