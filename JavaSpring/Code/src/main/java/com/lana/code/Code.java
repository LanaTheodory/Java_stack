package com.lana.code;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class Code {
	
	@RequestMapping("/")
	public String index1(){
	
	return  "index.jsp";
	}
	
	@RequestMapping(value="/code", method=RequestMethod.POST)
	public String index(@RequestParam(value="code") String code ){
	if(code.equals("bushido")) {
		return  "index2.jsp";
		
	}
	else {
	
	return  "redirect:/createError";
	}
		}
	
	
	@RequestMapping("/createError")
    public String flashMessages(RedirectAttributes redirectAttributes ) {
        redirectAttributes.addFlashAttribute("error", "You must train harder!");
        
        
        return "redirect:/";
    }
}
