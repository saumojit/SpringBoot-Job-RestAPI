package com.example.SpringBoot_Job_RestAPI.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    // Advice type : Around offers more control to the advice for the target obect/method
    // Without pjp.proceed() which returns an object -- advice won't call the target method
    // best use case - performance monitoring


    @Around("execution(* com.example.SpringBoot_Job_RestAPI.service.JobService.*(..)))")
    public Object monitorTime(ProceedingJoinPoint pjp) throws Throwable {
        long starttime = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long endtime = System.currentTimeMillis();
        // LOGGER.info(obj.toString());
        LOGGER.info("Time to Execute The API : " + pjp.getSignature().getName() +  "() " +  + (endtime-starttime) + " ms") ;
        return obj;
    }
}
