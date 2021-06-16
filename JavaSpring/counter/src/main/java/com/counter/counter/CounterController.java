package com.counter.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")

public class CounterController {
	int counter;
	
@RequestMapping("")
public String count1() {
	this.counter ++;
	
	
	return "index.jsp";
	
	
}

@RequestMapping("/counter")
public String count2(HttpSession session ) {
	 session.setAttribute("count", this.counter);
     Integer count = (Integer) session.getAttribute("count");

	
	
	
	return "index2.jsp";



	
	

}
}
