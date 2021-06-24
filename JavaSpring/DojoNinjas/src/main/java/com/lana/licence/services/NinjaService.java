package com.lana.licence.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lana.licence.models.Dojo;
import com.lana.licence.models.Ninja;

import com.lana.licence.repositories.NinjaRepo;

@Service
public class NinjaService {

	private final NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo ninjaRepo) {
		
		this.ninjaRepo = ninjaRepo;
	}

	
	
	public Ninja createNinja(Ninja d) {
		return ninjaRepo.save(d);
	}
	public List<Ninja> allNinja() {
		return  ninjaRepo.findAll();
	}
}
