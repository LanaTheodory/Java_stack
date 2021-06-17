package com.lana.logreg;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginRegistration {

	@RequestMapping("/")
	public String start() {

		return "index.jsp";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, @RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {

		if (email.equals("lana@email.com") && password.equals("12345678")) {
			if (session.getAttribute("email") == null) {
				session.setAttribute("email", email);
			}
			return "redirect:/welcome";
		}

		return "redirect:/";
	}

	@RequestMapping("/welcome")
	public String welcome(HttpSession session) {
		if(session.getAttribute("email") != null) {
			return "welcome.jsp";
		}

		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if (session.getAttribute("email") != null) {
			session.invalidate();
		}
		return "redirect:/";
	}

}
