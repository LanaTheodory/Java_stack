package com.lana.licence.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lana.licence.models.Dojo;
import com.lana.licence.repositories.DojoRepo;


@Service
public class DojoService {

	private final DojoRepo dojoRepo;

	
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo =dojoRepo;

	}
	public Dojo createDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public List<Dojo> allDojo() {
		return  dojoRepo.findAll();
	}
	
	public Dojo thisDojo(Long id) {
		
		return dojoRepo.findById(id).orElse(null);
	}
}
