package com.example.controllerTest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable int userId){

        User user=userService.getUserById(userId);
        return user;
    }
}
