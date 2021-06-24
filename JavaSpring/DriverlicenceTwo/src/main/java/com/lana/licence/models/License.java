package com.lana.licence.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name="licenses")
public class License {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Size(min=2)
	@Column(name="number")
    private String number;

	@Column(name="expirationDate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;
	
	@NotNull

	@Column(name="state")
    private String state;
  
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    
	   @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
   
    public License() {
        
    }
  
   
    
	public License(Date expirationDate, String state, Person person) {
		
		  
		this.expirationDate = expirationDate;
		this.state = state;
		this.person = person;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
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

