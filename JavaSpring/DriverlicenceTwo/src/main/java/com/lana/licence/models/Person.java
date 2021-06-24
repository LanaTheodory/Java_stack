package com.lana.licence.models;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "people")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=2)
	@NotNull
	@Column(name="firstname")
	private String firstName;

	@NotNull
	@Size(min=2)
	@Column(name="lastname")
	private String lastName;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private License license;
	
	  @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;

	public Person() {

	}
	

	public Person(String firstName, String lastName, License license) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.license = license;
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


	public License getLicense() {
		return license;
	}


	public void setLicense(License license) {
		this.license = license;
	}


	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
