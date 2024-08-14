package com.example.SpringBoot_Job_RestAPI.service;

import com.example.SpringBoot_Job_RestAPI.model.JobPost;
import com.example.SpringBoot_Job_RestAPI.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository repo;

    public void addJob(JobPost jobPost){
        System.out.println("service");
        repo.addJobToDB(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAllJobs();
    }

    public JobPost getJob(int jobPostId){
        return repo.getJobFromDB(jobPostId);
    }

    public void updateJob(JobPost jobPost){
        repo.updateJobDB(jobPost);
    }

    public void deleteJob(int jobPostId){
        repo.deleteJobFromDB(jobPostId);
    }

}
