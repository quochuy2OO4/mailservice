package com.org.mailservice.controller;

import com.org.mailservice.model.User;
import com.org.mailservice.service.UserService;
import com.org.mailservice.ultil.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        if (userService.getUserById(user.getId()) != null) {
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A User with id "
                    + user.getId() + " and name "
                    + user.getUser_name() + " already exist."), HttpStatus.CONFLICT);
        }
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
