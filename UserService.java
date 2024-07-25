package com.mahadev.login.service;



import java.util.List;

import com.mahadev.login.model.User;

public interface UserService {
   User findByEmail(String email);
    List<User> getAllUsers();
    void saveUser(User user);
}