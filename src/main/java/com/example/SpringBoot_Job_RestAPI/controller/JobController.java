package com.example.SpringBoot_Job_RestAPI.controller;

import com.example.SpringBoot_Job_RestAPI.model.JobPost;
import com.example.SpringBoot_Job_RestAPI.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// all apis running at http://localhost:8080
// @ResponseBody => endpoint outcome will be json/xml format
// @RequestBody => accepts request-body json/xml format and loads to the class object
// code also supports xml request-respoonse format with jackson-dataformat-xml


// @Controller
@RestController     // treats all endpoints inside the class as REST API ( NOT VIEW )
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService service ;

    // @ResponseBody -- granular to one endpoint
    @GetMapping("/jobposts")
    public List<JobPost> jobposts(){
        List<JobPost> items = service.getAllJobs();
        return items;
    }

    // Content Restriction ( It will produce xml response else throws 406 Error )
    // @GetMapping(path="/jobpost/{postId}" , produces = "application/xml")
    @GetMapping("/jobpost/{postId}")
    public JobPost jobpost(@PathVariable int postId){
        return service.getJob(postId);
    }

    // Content Restriction ( It will take json request-body only else throws 415 Error )
    // @PostMapping(path="/jobpost" , consumes = "application/json")
    @PostMapping("/jobpost")
    public JobPost addjob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("/jobpost")
    public JobPost updatejob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/jobpost/{postId}")
    public String deletejob(@PathVariable int postId){
        service.deleteJob(postId);
        return "JobPost Deleted !";
    }
}
