package com.lana.licence.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lana.licence.models.Dojo;
import com.lana.licence.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoServ;
	
	public DojoController(DojoService dojoServ) {
		this.dojoServ= dojoServ;
	}
@RequestMapping("/")
public String dojos(@ModelAttribute("dojo") Dojo dojo) {
	
	return"dojo.jsp";
}
@PostMapping("/dojo/new")
public String createDojos(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	if(result.hasErrors()) {
		return "dojo.jsp";
	} else
		dojoServ.createDojo(dojo);
	return "redirect:/ninja/new";
}
@RequestMapping("/profile/{id}")
public String profile(@PathVariable("id")Long id,Model model ) {
	model.addAttribute("dojo", dojoServ.thisDojo(id));
	return"profile.jsp";
}
}
