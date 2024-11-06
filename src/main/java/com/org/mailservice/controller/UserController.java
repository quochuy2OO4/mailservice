package com.org.mailservice.controller;

import com.org.mailservice.model.User;
import com.org.mailservice.service.UserService;
import com.org.mailservice.ultil.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // Retrieve All Users
    @GetMapping("/api/user")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> listUsers = userService.getAllUsers();

        if (listUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listUsers, HttpStatus.OK);
    }

    // Restful API to Create a User
    @PostMapping("/api/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        // Check employee is existed
        if (userService.getUserByUserName(user.getUserName()) != null) {
            return new ResponseEntity<>(new CustomErrorType("Unable to create. "
                    + user.getUserName() + " already exist."), HttpStatus.CONFLICT);
        }

        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    // Update password user
    @PutMapping("/api/user/{id}")
    public ResponseEntity<?> updatePasswordUser(@PathVariable("id") long id, @RequestBody User user) {
        User currentUser = userService.getUserById(id);
        if (currentUser == null) {
            return new ResponseEntity<>(new CustomErrorType("User with ID " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        currentUser.setPassword(user.getPassword());
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }
}
