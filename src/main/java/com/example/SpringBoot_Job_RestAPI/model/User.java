package com.example.SpringBoot_Job_RestAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String username ;
    private String password ;
}
