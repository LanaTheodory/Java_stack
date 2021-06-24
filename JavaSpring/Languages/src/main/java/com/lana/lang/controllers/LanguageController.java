package com.lana.lang.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lana.lang.models.Language;

import com.lana.lang.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService LanguageService;

	public LanguageController(LanguageService LanguageService) {
		this.LanguageService = LanguageService;

	}

	@RequestMapping("/language")
	public String index(Model model, @ModelAttribute("language") Language languages) {
		List<Language> language1 = LanguageService.alllangs();
//	     Language language=new Language();
		model.addAttribute("languages", language1);
//	     model.addAttribute("language", language);
		return "index1.jsp";
	}

	@RequestMapping("/languages/edit/{id}")
	public String edit(Model model, @PathVariable("id") long id) {
		Language lang1 = LanguageService.findlang(id);
		model.addAttribute("language", lang1);
		return "edit.jsp";
	}

//	@RequestMapping(value = "/languages/update/{id}", method = RequestMethod.PUT)
//	public String update(@Valid @PathVariable("id") Long id, @ModelAttribute("name") String name,
//			@ModelAttribute("creator") String creator, @ModelAttribute("currentVersion") double currentVersion,
//			BindingResult result) {
//		if (result.hasErrors()) {
//			return "edit.jsp";
//		} else {
//
//			LanguageService.updatelan(id, name, creator, currentVersion);
//			return "redirect:/language";
//		}
	@RequestMapping(value = "/languages/update/{id}", method = RequestMethod.PUT)
	public String update(@Valid  @ModelAttribute("language") Language lan, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {

			LanguageService.updatelan( lan);
			return "redirect:/language";
		}
	}

	@RequestMapping(value = "/languages/add", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language lang, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			List<Language> alllang = LanguageService.alllangs();
			model.addAttribute("languages", alllang);
			return "index1.jsp";
		} else {

			LanguageService.createLanguage(lang);
			return "redirect:/language";
		}
	}

	@RequestMapping(value = "/languages/delete/{id}")
	public String delete(@PathVariable("id") Long id) {

		LanguageService.deletelang(id);

		return "redirect:/language";
	}

	@RequestMapping("/languages/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language lang = LanguageService.findlang(id);
		model.addAttribute("language", lang);
		return "show.jsp";
	}
}
