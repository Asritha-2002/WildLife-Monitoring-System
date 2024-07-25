package com.mahadev.login.model;

import jakarta.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fname;
    private String lname;
    private String email;
    private String password;
    private String confirmPassword;
   

  
   

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFName() {
        return fname;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }
    public String getLName() {
        return lname;
    }

    public void setLName(String lname) {
        this.lname = lname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setCpassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

   
}