package com.example.fel.service;

import com.example.fel.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUser(Long id);
    void deleteUser(Long id);
    void updateUser(User user);
    User findUserByUsername(String username);
}
