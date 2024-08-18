package com.example.SpringBoot_Job_RestAPI.repository;

import com.example.SpringBoot_Job_RestAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
