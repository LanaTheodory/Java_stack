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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="students")
public class Student {

	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name="first_name")
	private String first_name;
    @NotNull
    @Column(name="last_name")
	private String last_name;
    
    public Student() {}
    public Student( String first_name,  String last_name,  Integer age, Contact contact) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.contact = contact;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@NotNull
    @Column(name="age")
    private Integer age;
    
    @OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Contact contact;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
}
