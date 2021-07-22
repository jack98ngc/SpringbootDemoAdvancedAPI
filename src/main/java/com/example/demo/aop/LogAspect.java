/*
 * created on Jul 21, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 21, 2021 $
 */
package com.example.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.example.demo.api.LogTestApi.log(..))")
    public void log() {
        
    }
    
    @Before("log()")
    public void doBefore() {
        logger.info("----------- doBefore 1 ------------");
    }
    @After("log()")
    public void doAfter() {
        logger.info("----------- doAfter 2 ------------");
    }
    
    @AfterReturning(returning="result", pointcut="log()")
    public void doAfterReturning(Object result) {
        logger.info("----------- doAfterReturning  : {}  ------------", result);
    }
}
