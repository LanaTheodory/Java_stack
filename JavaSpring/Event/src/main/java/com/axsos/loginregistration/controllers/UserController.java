package com.axsos.loginregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.loginregistration.models.Event;
import com.axsos.loginregistration.models.EventUser;
import com.axsos.loginregistration.models.Message;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.services.EventService;
import com.axsos.loginregistration.services.UserService;
import com.axsos.loginregistration.validation.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final EventService eventService;

	public UserController(UserService userService, UserValidator userValidator, EventService eventService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.eventService = eventService;
	}

	@RequestMapping("")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
// We dont needed because we will display in the same page
//    @RequestMapping("/login")
//    public String login(HttpSession session) {
//    	if (session.getAttribute("userID") !=null)
//    		return "redirect:/home";
//        return "loginPage.jsp";
//    }

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpSession session) {
		userValidator.validate(user, result);

		if (result.hasErrors())
			return "registrationPage.jsp";
		if (userService.findByEmail(user.getEmail()) != null) {
			model.addAttribute("error", "This email already exist!!");
			return "registrationPage.jsp";
		}
		userService.registerUser(user);
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user") User user, @RequestParam("email") String email,
			@RequestParam("password") String password, Model model, HttpSession session) {
		// if the user is authenticated, save their user id in session
		// else, add error messages and return the login page
		if (userService.authenticateUser(email, password)) {
			session.setAttribute("userId", userService.findByEmail(email).getId());
			return "redirect:/home";
		} else {
			model.addAttribute("error", "Invalid User name or Password");
			return "registrationPage.jsp";
		}
	}

	// for second page
	@RequestMapping("/home")
	public String home(HttpSession session, Model model, @ModelAttribute("event") Event event) {
		// get user from session, save them in the model and return the home page
		if (session.getAttribute("userId") == null)
			return "redirect:/";
		Long Id = (Long) session.getAttribute("userId");
		User u = userService.findUserById(Id);
		model.addAttribute("user", u);
		model.addAttribute("usersStates", eventService.eventState(u.getState())); // for userState
		model.addAttribute("otherStates", eventService.eventNotState(u.getState())); // for userNotState
		return "homePage.jsp";

	}

	// create event
	@PostMapping("/events")
	public String newEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model,
			HttpSession session) {

		Long Id = (Long) session.getAttribute("userId");
		User u = userService.findUserById(Id);
		model.addAttribute("user", u);
		model.addAttribute("usersStates", eventService.eventState(u.getState())); // for userState validation
		model.addAttribute("otherStates", eventService.eventNotState(u.getState())); // for userNotState validation
		if (result.hasErrors())
			return "homePage.jsp";
		eventService.createEvent(event);
		return "redirect:/home";
	}
	//logout
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
        session.invalidate();
        return "redirect:/"; 
    }
    //join event
    @RequestMapping("/events/{id}/a/join")
    public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
    	Event event = eventService.findEventById(id);
    	User user = userService.findUserById((Long)	session.getAttribute("userId"));
//		user.getEventsAttending().add(event); //if using two tables to join
//		userService.updateUser(user);
    	eventService.createAttending(event, user);
    	return "redirect:/home";
    	
    }
    //cancel join
    @RequestMapping("/events/{id}/a/cancel")
	public String cancelJoin(@PathVariable("id")Long id,HttpSession session) {
		Event event=eventService.findEventById(id);
		EventUser a=eventService.findEventUserByEvent(event);
		eventService.cancelEventUser(a);
		return "redirect:/home";
	}
    //delete event
    @DeleteMapping("/events/{id}")
    public String deleteEvent(@PathVariable("id")Long id, HttpSession session) {
    	Event event=eventService.findEventById(id);
    	eventService.deleteEvent(event);
    	return "redirect:/home";
    	
    }

    //show
    @RequestMapping("/events/{id}")
    public String showEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
    	model.addAttribute("event", eventService.findEventById(id));
    	return "show.jsp";
    }
    //create message
    @PostMapping("/events/{id}/comment")
    public String newMessage(@RequestParam("comment") String content, @PathVariable("id") Long id,HttpSession session, Model model) {
    	User author=userService.findUserById((Long) session.getAttribute("userId"));
    	Event event=eventService.findEventById(id);
    	Message message = new Message(content, author, event);
    	eventService.createMessage(message);
    	return "redirect:/events/"+id;
    	
    }
    //edit and update
    @GetMapping("events/{id}/edit")
	public String Edit(@PathVariable("id") Long id, HttpSession session, Model model) {
    	Long Id = (Long) session.getAttribute("userId");
    	Event event=eventService.findEventById(id);
	
		if(session.getAttribute("userId") == null)
			return "redirect:/";
		if(event == null || !event.getPlanner().getId().equals(session.getAttribute("userId")))
			return "redirect:/events";
		
		model.addAttribute("event", event);
		//model.addAttribute("states", State.States);
		model.addAttribute("userId", Id);
		return "edit.jsp";
	}
	@PutMapping("/{id}")
	public String Update(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		if(result.hasErrors()) {
			Long Id = (Long) session.getAttribute("userId");
			model.addAttribute("event", event);
			//model.addAttribute("states", State.States);
			model.addAttribute("userId", Id);
			return "edit.jsp";
		}
		
		this.eventService.update(event);
		return "redirect:/home";
	}
    	
}
	
    

