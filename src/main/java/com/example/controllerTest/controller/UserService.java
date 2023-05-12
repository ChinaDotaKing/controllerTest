package com.example.controllerTest.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList=new ArrayList<>();


    public UserService(){
        userList.add(new User(1,"jane"));
        userList.add(new User(2,"jay"));
        userList.add(new User(3,"jack"));
    }

    public User getUserById(int userId) {

        return userList.get(userId-1);
    }
}
