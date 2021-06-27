package com.lana.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lana.loginreg.models.User;
import com.lana.loginreg.services.UserService;
import com.lana.loginreg.validation.UserValidate;

//imports removed for brevity
@Controller
public class UserController {
	private final UserService userService;
	 private final UserValidate userValidator;
	    
	  
	    public UserController(UserService userService, UserValidate userValidator) {
	        this.userService = userService;
	        this.userValidator = userValidator;
	    }
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}

	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		} else {
			if(userService.findByEmail(user.getEmail()) != null) {
				model.addAttribute("error", "this email already exists");
				return "registrationPage.jsp";
			}
			userService.registerUser(user);
			session.setAttribute("userId", user.getId());
			return "redirect:/home";	
		}
		
		
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		// if the user is authenticated, save their user id in session
		if(userService.authenticateUser(email, password)) {
			session.setAttribute("userId", userService.findByEmail(email).getId());
			return "redirect:/home";
		} else {
			model.addAttribute("error", "Invalid user name or password");
			return "loginPage.jsp";
		}
	
	}

	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
	
		if(session.getAttribute("userId") == null) {
			return "redirect/registration";
		}else {
		Long id = (Long) session.getAttribute("userId");
		User u = userService.findUserById(id);
		model.addAttribute("user", u);
		return "homePage.jsp";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	
	}
}