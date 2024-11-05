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
        List<User> listUser = userRepository.findAll();
        if (listUser.isEmpty()) {
            throw new RuntimeException("User empty");
        }
        return listUser;
    }

    // Add a single user
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Find user by id
    public User getUserById(long id) {

        return userRepository.findById(id).orElse(null);
    }

    // Delete user with user id
    public void deleteUser(long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    // update user
    public User updateUser(long id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null) {
            throw new RuntimeException("User not found");
        }

        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

}
