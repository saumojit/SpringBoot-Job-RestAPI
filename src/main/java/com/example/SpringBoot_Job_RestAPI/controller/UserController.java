package com.example.SpringBoot_Job_RestAPI.controller;


import com.example.SpringBoot_Job_RestAPI.model.User;
import com.example.SpringBoot_Job_RestAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service ;

    @PostMapping("/register")
    public User hello(@RequestBody User user){
        return service.addUser(user);
    }
}
