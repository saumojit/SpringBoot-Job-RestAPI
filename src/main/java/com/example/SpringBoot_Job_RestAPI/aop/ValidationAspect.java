package com.example.SpringBoot_Job_RestAPI.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    // Advice type : Around offers more control to the advice for the target obect/method
    // Without pjp.proceed() which returns an object -- advice won't call the target method
    // We can pass input arguments from target method to the advice as well

    @Around("execution(* com.example.SpringBoot_Job_RestAPI.service.JobService.getJob(..)) && args(jobPostId)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp , int jobPostId) throws Throwable {
        if(jobPostId < 0){
            LOGGER.info("Received Negative/Invalid ID as Given jobPostId Value = " + jobPostId  + " Updating it ...");
            jobPostId=-jobPostId;
            LOGGER.info("Upated jobPostId Value = " + jobPostId  );
        }
        Object obj=pjp.proceed(new Object[]{jobPostId});
        return obj;
    }
}
