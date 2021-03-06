package com.codeclan.example.files_and_folders.controllers;


import com.codeclan.example.files_and_folders.models.User;
import com.codeclan.example.files_and_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        return new ResponseEntity(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value="/users")
    public ResponseEntity postUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
