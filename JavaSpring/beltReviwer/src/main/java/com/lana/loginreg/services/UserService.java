package com.lana.loginreg.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.lana.loginreg.models.Attend;
import com.lana.loginreg.models.Event;
import com.lana.loginreg.models.Message;
import com.lana.loginreg.models.State;
import com.lana.loginreg.models.User;
import com.lana.loginreg.repositories.AttendRepo;
import com.lana.loginreg.repositories.EventRepo;
import com.lana.loginreg.repositories.MessageRepo;
import com.lana.loginreg.repositories.StateRepo;
import com.lana.loginreg.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final EventRepo eventRepo;
	private final AttendRepo attendRepo;
	private final MessageRepo messageRepo;
	private final StateRepo stateRepo;

	public UserService(UserRepository userRepository, EventRepo eventRepo, AttendRepo attendRepo, StateRepo stateRepo,
			MessageRepo messageRepo) {
		this.userRepository = userRepository;
		this.eventRepo = eventRepo;
		this.attendRepo = attendRepo;
		this.messageRepo = messageRepo;
		this.stateRepo = stateRepo;
	}

	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	// find user by id
	public User findUserById(Long id) {
		Optional<User> u = userRepository.findById(id);

		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}

	public boolean authenticateUser(String email, String password) {
		// first find the user by email
		User user = userRepository.findByEmail(email);
		// if we can't find it by email, return false
		if (user == null) {
			return false;
		} else {

			if (BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}


///////////////////////////////////////////////////////////////////////////
//eventService

public Event createEvent(Event e) {
return eventRepo.save(e);
}

public Event findEventById(Long id) {
	return eventRepo.findById(id).orElse(null);
}

///////////////////////////////////////////////////////////////////////////
public Message createEvent(Message e) {
return messageRepo.save(e);
}

public Message findMessageById(Long id) {
	return messageRepo.findById(id).orElse(null);
}

///////////////////////////////////////////////////////////////////////////

public Attend createAttend(Attend e) {
return attendRepo.save(e);
}

public Attend findAttendById(Long id) {
	return attendRepo.findById(id).orElse(null);
}
///////////////////////////////////////////////////////////////////////////
public State createState(State e) {
return stateRepo.save(e);
}

public State findstateById(Long id) {
	return stateRepo.findById(id).orElse(null);
}

public List<State> findAllStates(){
	return stateRepo.findAll();
}




}
