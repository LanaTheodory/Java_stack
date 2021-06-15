package com.lana.routes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("/{dojo}")
	public String dojo2(@PathVariable("dojo") String dojo) {
		if(dojo.equals("Dojo")) {
		return dojo + "is awsome!" ;
		}
		else if(dojo.equals("Burbank")) {
			return dojo + "is located in Southern California ";
		}
		else if(dojo.equals("san-jose")) {
			return dojo + "dojo is the headquarters ";
			
		}
		else 
			return "ay eshi";
	}
	



	
}
