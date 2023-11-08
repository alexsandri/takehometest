package com.tugaslife.tugasapi.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

     @NotEmpty(message="First Name not be null")
    @Column(name="firstname",length=100)
    private String firstname;

     @NotEmpty(message="Last Name is required")
    @Column(name="lastname",length=100)
    private String lastname;

    private String dob;

    // @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDate createdAt;

    // @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private LocalDate updatedAt;

    public User() {
    }

    public User(Long id, String firstname, String lastname, String dob, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    public String getfirstname() {
        return firstname;
    }

    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }




}
