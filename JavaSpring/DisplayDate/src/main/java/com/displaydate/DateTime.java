package com.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateTime {
	
	@RequestMapping("/")
    public String index() {
		
        return "index.jsp"; 
        }
	
	
	@RequestMapping("/date")
    public String index1(Model model) {
		Date today = new Date(); 
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		String date = DATE_FORMAT.format(today);
		
		model.addAttribute("date", date);
        return "index2.jsp"; 
        }
	
	@RequestMapping("/time")
    public String index2(Model model) {
		Date today = new Date(); 
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:SS");
		String time = DATE_FORMAT.format(today);
		
	
		model.addAttribute("time", time );
        return "index3.jsp"; 
}
}