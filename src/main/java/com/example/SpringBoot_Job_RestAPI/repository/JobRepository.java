package com.example.SpringBoot_Job_RestAPI.repository;

import com.example.SpringBoot_Job_RestAPI.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobPost , Integer> {

    // Spring DSL already does the implementation for the below method by going through Model Class
    public List<JobPost> findByPostProfileContainingOrPostDescContaining(String kw_postprofile , String kw_postdesc);
}