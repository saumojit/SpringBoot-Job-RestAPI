package com.example.SpringBoot_Job_RestAPI.service;

import com.example.SpringBoot_Job_RestAPI.model.UserDetailsImpl;
import com.example.SpringBoot_Job_RestAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.SpringBoot_Job_RestAPI.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceForJob implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user==null){
            System.out.println("User Not Found , 404");
            throw new UsernameNotFoundException("User from users table Not Found , 404");
        }
        return new UserDetailsImpl(user);
    }
}
