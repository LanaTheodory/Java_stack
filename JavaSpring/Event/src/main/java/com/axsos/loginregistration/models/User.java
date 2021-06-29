package com.axsos.loginregistration.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 @Size(min=2, max=20, message="First Name must be greater than 2 characters")
 private String firstName;
 @Size(min=2, max=20, message="Last Name must be greater than 2 characters")
 private String lastName;
 @Email(message="Email must be valid")
 private String email;
 @NotEmpty
 private String state;
 @NotEmpty
 private String city;
 @Size(min=5, message="Password must be greater than 5 characters")
 private String password;
 @Transient
 private String passwordConfirmation;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @OneToMany(mappedBy="planner", fetch = FetchType.LAZY)
 private List<Event> eventsPlanned;
 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(
     name = "events_users", 
     joinColumns = @JoinColumn(name = "user_id"), 
     inverseJoinColumns = @JoinColumn(name = "event_id")
 )
 private List<Event> eventsAttending;
 @OneToMany(mappedBy="author", fetch = FetchType.LAZY)
 private List<Message> messages;
 
 public User() {
 }
 
 public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPasswordConfirmation() {
	return passwordConfirmation;
}

public void setPasswordConfirmation(String passwordConfirmation) {
	this.passwordConfirmation = passwordConfirmation;
}

public List<Event> getEventsPlanned() {
	return eventsPlanned;
}

public void setEventsPlanned(List<Event> eventsPlanned) {
	this.eventsPlanned = eventsPlanned;
}

public List<Event> getEventsAttending() {
	return eventsAttending;
}

public void setEventsAttending(List<Event> eventsAttending) {
	this.eventsAttending = eventsAttending;
}

public List<Message> getMessages() {
	return messages;
}

public void setMessages(List<Message> messages) {
	this.messages = messages;
}

@PrePersist
 protected void onCreate(){
     this.createdAt = new Date();
 }
 @PreUpdate
 protected void onUpdate(){
     this.updatedAt = new Date();
 }
}