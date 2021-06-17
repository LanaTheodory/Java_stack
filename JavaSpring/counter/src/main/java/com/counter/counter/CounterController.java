package com.counter.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")

public class CounterController {

	
@RequestMapping("")
public String count1(HttpSession session) {
	if(session.getAttribute("count") == null) {
		 session.setAttribute("count", 0);
		 
	}
	else {
		increment(session);
		 
		 
	}
	
	
	return "index.jsp";
	
	
}

public void increment(HttpSession session) {
	 int counter = (int) session.getAttribute("count");
	 counter++;
	 session.setAttribute("count",counter);
	
}

@RequestMapping("/counter")
public String count2(HttpSession session ) {
	
     Integer count = (Integer) session.getAttribute("count");

	
	
	
	return "index2.jsp";



	
	

}
}
