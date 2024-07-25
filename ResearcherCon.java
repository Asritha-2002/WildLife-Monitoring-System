package com.mahadev.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahadev.login.model.Researcher;

import com.mahadev.login.service.ResearcherSer;

@RestController
public class ResearcherCon {
     @Autowired
    private ResearcherSer userService;

    @PostMapping("/signup")
    public String signup(@RequestBody Researcher user) {
        if (userService.findByEmail(user.getEmail()) != null) {
            return "error: Email already exists";
        }

        userService.saveResearcher(user);
        return "success";
    }

    @PostMapping("/signin")
    public String signin(@RequestBody SigninRequest request) {
        Researcher user = userService.findByEmail(request.getEmail());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            return "success";
        } else {
            return "error: User not found or password incorrect";
        }
    }

    // Getter and Setter methods for LoginRequest class
    static class SigninRequest {
        private String email;
        private String password;

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
    }
}
