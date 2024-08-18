package com.example.SpringBoot_Job_RestAPI.aop;

import com.example.SpringBoot_Job_RestAPI.model.JobPost;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class LoggingAspect {
    private static Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/advice.html#aop-advice-after-throwing
    // PointCut Expression Syntax -->
    // Supported-Pointcut-Designators ( <return-type> <fully-qualified class-name>.<method-name>(<args>) )
    // we can have multiple pointcut expressions -- @Before("<pointcut-expression-1> || <pointcut-expression-2>")
    // JoinPoint holds the target object

    // Note - Other than arguments -- * means all or anything
    // Note - Specific to arguments (..) :- Zero or more arguments , (*) :- Only one argument , () :- No arguments
    // Example - @Before("execution(* *.*(..))")

    //  //           Below are the Advices declared with pointcut expression       //  //

    @Before("execution(* com.example.SpringBoot_Job_RestAPI.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method(Service) Called + " + jp.getSignature().getName());
    }

    @After("execution(* com.example.SpringBoot_Job_RestAPI.service.JobService.*(..))")
    public void logMethodCallFinally(JoinPoint jp){
        LOGGER.info("Method(Service) Finally Executed + " + jp.getSignature().getName());
    }

//    @AfterReturning("execution(* com.example.SpringBoot_Job_RestAPI.service.JobService.*(..))")
//    public void logMethodCallonSuccess(JoinPoint jp){
//        LOGGER.info("Method(Service) Executed Successfully + " + jp.getSignature().getName());
//    }

    @AfterReturning(pointcut = "execution(* com.example.SpringBoot_Job_RestAPI.service.JobService.*(..))",
                    returning = "alljobs")
    public void logMethodCallonSuccess2(JoinPoint jp , List<JobPost> alljobs){
        LOGGER.info("Method(Service) Executed Successfully + " + jp.getSignature().getName());
        LOGGER.info(alljobs.toString());
    }


    @AfterThrowing("execution(* com.example.SpringBoot_Job_RestAPI.service.JobService.*(..))")
    public void logMethodCallonError(JoinPoint jp){
        LOGGER.info("Method(Service) Executed with Error + " + jp.getSignature().getName());
    }

    @AfterThrowing( pointcut = "execution(* com.example.SpringBoot_Job_RestAPI.service.JobService.getAllJobs(..))" ,
                    throwing = "err")
    public void logMethodCallonError2(JoinPoint jp , Exception err){
        LOGGER.info("Method(Service) Executed with Error + " + jp.getSignature().getName());
        LOGGER.error(String.valueOf(err));
    }

//    @Before("execution(public * com.example.SpringBoot_Job_RestAPI.service.JobService.*(..))")
//    public void logMethodCall2(JoinPoint jp){
//        LOGGER.info("Method(Service) Called + " + jp.getSignature().getName());
//    }
}
