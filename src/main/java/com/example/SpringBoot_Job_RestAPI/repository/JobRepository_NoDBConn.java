package com.example.SpringBoot_Job_RestAPI.repository;

import com.example.SpringBoot_Job_RestAPI.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepository_NoDBConn {
    private List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1,"Java Developer","SpringBoot",4,Arrays.asList("Spring","Java")) ,
            new JobPost(2,"SpringBoot Developer","4+ of Experince",3,Arrays.asList("SpringBoot","Hibernate")) ,
            new JobPost(3,"Kafka Developer","4+ of Experince",2,Arrays.asList("SpringBoot","Hibernate")) ,
            new JobPost(4,"CoreJava Developer","4+ of Experince",1,Arrays.asList("SpringBoot","Hibernate"))
            ));

    public void addJobToDB(JobPost jobPost){
        jobs.add(jobPost);
        // System.out.println(jobs);
    }

    public List<JobPost> findAllJobs(){
        // System.out.println(jobs);
        return jobs;
    }

    public JobPost getJobFromDB(int jobPostId){
        for (JobPost job : jobs) {
            if(job.getPostId()==jobPostId)
                return job;
        }
        return null;
    }

    public void deleteJobFromDB(int jobPostId) {
        for (int i=0 ; i<jobs.size();i++) {
            if(jobs.get(i).getPostId()==jobPostId){
                jobs.remove(i);
                System.out.println("job-post with id=" + jobPostId + " has been removed from db.");
            }
        }
    }

    public void updateJobDB(JobPost newJobPost) {
        for (JobPost job : jobs) {
            if (job.getPostId() == newJobPost.getPostId()) {
                job.setPostDesc(newJobPost.getPostDesc());
                job.setPostProfile(newJobPost.getPostProfile());
                job.setReqExperience(newJobPost.getReqExperience());
                job.setPostTechStack(newJobPost.getPostTechStack());
                System.out.println("job-post with id=" + job.getPostId() + " has been updated in db.");
            }
        }
    }
}