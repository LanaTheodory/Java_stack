package com.axsos.loginregistration.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.loginregistration.models.Event;
import com.axsos.loginregistration.models.EventUser;
import com.axsos.loginregistration.models.Message;
import com.axsos.loginregistration.models.User;
import com.axsos.loginregistration.repositories.EventRepository;
import com.axsos.loginregistration.repositories.EventUserRepository;
import com.axsos.loginregistration.repositories.MessageRepository;

@Service
public class EventService {
	private final EventRepository eventRepository;
	private final EventUserRepository eventUserRepository;
	private final MessageRepository messageRepository;

	public EventService(EventRepository eventRepository,EventUserRepository eventUserRepository,MessageRepository messageRepository) {
		this.eventRepository = eventRepository;
		this.eventUserRepository = eventUserRepository;
		this.messageRepository = messageRepository;
	}
	public List<Event> eventState (String state){
		return eventRepository.findByState(state);
	}
	public List<Event> eventNotState (String state){
		return eventRepository.findByStateIsNot(state);
	}
	public void createEvent(Event event) {
		eventRepository.save(event);
	}
	//bring event by id
	public Event findEventById(Long id) {
		return eventRepository.findById(id).orElse(null);
		
	}
	//&joining event
	public void createAttending(Event event,User user) {
		EventUser attendees= new EventUser(event,user);
		eventUserRepository.save(attendees);
	}
	//bring id
	public EventUser findEventUserByEvent(Event event) {
		return eventUserRepository.findByEvent(event);
	}
	//cancel join
	public void cancelEventUser(EventUser a) {
		
		eventUserRepository.delete(a);
	}
	//delete event
	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}
	//create message
	public void createMessage(Message message) {
		messageRepository.save(message);
	}
	//update event
	public Event update(Event event) {
		return eventRepository.save(event);
	}

}
