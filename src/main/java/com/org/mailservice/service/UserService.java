package com.org.mailservice.service;

import com.org.mailservice.model.User;
import com.org.mailservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Add a single user
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Find user by id
    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Find user by username
    public User getUserByUserName(String userName) {
        return userRepository.getByUserName(userName);
    }

    // Delete user with user id
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    // update user
    public User updateUser(long id, User user) {
        return userRepository.save(user);
    }

}
