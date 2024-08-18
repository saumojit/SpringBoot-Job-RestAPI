package com.example.SpringBoot_Job_RestAPI.service;

import com.example.SpringBoot_Job_RestAPI.model.User;
import com.example.SpringBoot_Job_RestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public User addUser(User user){
        if(repo.findById(user.getId()).isEmpty()){
            user.setPassword(encoder.encode(user.getPassword()));
            return repo.save(user);
        }
        return user;
    }
}
