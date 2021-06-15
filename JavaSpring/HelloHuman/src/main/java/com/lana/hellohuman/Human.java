package com.lana.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Human {
	@RequestMapping("/your_server/")
	public String human(@RequestParam(value="q", required=false) String searchQuery) {
		if(searchQuery == null) {
			searchQuery = "Human!";
		}
		return "<h1>hello"+ " " + searchQuery + "</h1><p>welcome to springboot</p>";
	}
	

}
