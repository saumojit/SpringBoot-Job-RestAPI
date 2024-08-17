package com.example.SpringBoot_Job_RestAPI.service;

import com.example.SpringBoot_Job_RestAPI.model.JobPost;
import com.example.SpringBoot_Job_RestAPI.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository repo;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int jobPostId){
        return repo.findById(jobPostId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public void deleteJob(int jobPostId){
        repo.deleteById(jobPostId);
    }

    public void otl_onetimeload(){
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1,"Java Developer","SpringBoot",4,Arrays.asList("Spring","Java")) ,
                new JobPost(2,"SpringBoot Developer","1+ of Experince",3,Arrays.asList("Python","Hibernate")) ,
                new JobPost(3,"Kafka Developer","2+ of Experince",2,Arrays.asList("Java","Django")) ,
                new JobPost(4,"CoreJava Developer","10+ of Experince",1,Arrays.asList("API","Data Engg"))
        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> searchJobsByKeyword(String keyword){
        return repo.findByPostProfileContainingOrPostDescContaining(keyword , keyword);
    }

}
