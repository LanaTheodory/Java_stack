package com.lana.licence.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lana.licence.models.Ninja;
import com.lana.licence.services.DojoService;
import com.lana.licence.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaServ;
	private final DojoService dojoServ;
	public NinjaController(NinjaService ninjaServ, DojoService dojoServ) {
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
	}
	@RequestMapping("/ninja/new")
	public String ninjas(@ModelAttribute("ninja") Ninja ninja , Model model) {
		model.addAttribute("dojo",dojoServ.allDojo());
		return"ninja.jsp";
	}
	@PostMapping("/ninja/new/add")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//		if(result.hasErrors()) {
//			return "ninja.jsp";
//		} else
			System.out.println("ccccccccccccccccccccccccccccccccccccccccccccccccccccc");
			ninjaServ.createNinja(ninja);
		return "redirect:/profile/"+ ninja.getDojo().getId();
	}

	
}
