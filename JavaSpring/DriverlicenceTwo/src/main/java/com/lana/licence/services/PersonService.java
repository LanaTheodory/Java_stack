package com.lana.licence.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lana.licence.models.License;
import com.lana.licence.models.Person;
import com.lana.licence.repositories.LicenceRepo;
import com.lana.licence.repositories.PersonRepo;

@Service
public class PersonService {
	private final PersonRepo personrepo;
	private final LicenceRepo licencerepo;
	
	public PersonService( PersonRepo personrepo,LicenceRepo licencerepo) {
		this.personrepo = personrepo;
		this.licencerepo = licencerepo;
	}
	

public Person createPerson(Person person) {
	return personrepo.save(person);
}

public List<Person> allPeople(){
	return personrepo.findAll();
}
public License createLicense (License  license) {
	 License topNumber = licencerepo.findTopByOrderByNumberDesc();
     int number;
     if (topNumber == null)
         number = 1;
     else {
         number = Integer.parseInt(topNumber.getNumber());
         number++;
     }
     String numberString = String.format("%05d",number);
    
     license.setNumber(numberString);
  
	 return licencerepo.save(license);
}

public List<License > allLicenses(){
	return licencerepo.findAll();
}

public Person findPerson(Long id) {
	return personrepo.findById(id).orElse(null);
}
	public List<Person> peopleWithoutLicense(){
		return personrepo.findByLicenseIdIsNull();
	}

}
