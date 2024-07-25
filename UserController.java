package com.mahadev.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mahadev.login.model.User;
import com.mahadev.login.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userService.findByEmail(user.getEmail()) != null) {
            return "error: Email already exists";
        }

        userService.saveUser(user);
        return "success";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if (user != null && user.getPassword().equals(request.getPassword())) {
            return "success";
        } else {
            return "error: User not found or password incorrect";
        }
    }

    // Getter and Setter methods for LoginRequest class
    static class LoginRequest {
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
