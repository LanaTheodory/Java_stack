package com.lana.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	
@RequestMapping("")
	public String first() {
		return "Hello coding Dojo!";
	}

@RequestMapping("/python")
public String python() {
	return "/'pthon django!/'";
}
@RequestMapping("/java")
public String java() {
	return "/'java spring!/'";
}
}
