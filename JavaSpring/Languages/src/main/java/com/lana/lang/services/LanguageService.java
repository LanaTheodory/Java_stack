package com.lana.lang.services;


import java.util.*;

import org.springframework.stereotype.Service;

import com.lana.lang.models.Language;
import com.lana.lang.repositories.languageRepo;




@Service
public class LanguageService {

	private final languageRepo languageRepo;
	
	public LanguageService(languageRepo languageRepo ) {
		this.languageRepo = languageRepo;
		
	}
	public List<Language> alllangs() {
		return languageRepo.findAll();
	}
	public Language createLanguage(Language b) {
		return languageRepo.save(b);
	}
	public Language findlang(Long id) {
		Optional<Language> optionallang = languageRepo.findById(id);
		if (optionallang.isPresent()) {
			return optionallang.get();
		} else {
			return null;
		}
	}
	public Language updatelan(Long id, String name, String creator, double currentVersion) {

		Language lan = languageRepo.findById(id).orElse(null);
		lan.setName(name);
		lan.setCreator(creator);
		lan.setCurrentVersion(currentVersion);
		return languageRepo.save(lan);
	}
	public void deletelang(Long id) {
		languageRepo.deleteById(id);
		
	}

}

