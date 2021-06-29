package com.lana.events.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue()
    private Long id;
    @NotNull
    @Size(min=2, max=70)
    private String firstname;
    
    @NotNull
    @Size(min=2, max=70)
    private String lastname;
    
    @NotNull
    @Size(min=1, max=70)
    private String location;
    // NEW
    @Email(message="Email must be valid")
    private String email;
    // NEW
    @Size(min=5, message="Password must be greater than 5 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public User() {
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