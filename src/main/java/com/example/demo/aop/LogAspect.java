/*
 * created on Jul 21, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 21, 2021 $
 */
package com.example.demo.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.example.demo.api.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String className = joinPoint.getSignature()+"."+joinPoint.getSignature().getName();
        RequestLog requestLog = new RequestLog(request.getRequestURL().toString(), request.getRemoteHost(), className, joinPoint.getArgs());
        
        logger.info("- Request  -------- {}", requestLog);
    }

    @After("log()")
    public void doAfter() {
        logger.info("----------- doAfter 2 ------------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result) {
        logger.info(" Return ------ {} ", result);
    }
    
    @AfterThrowing(pointcut = "log()", throwing="e")
    public void doAfterThrowing(Throwable e) {
        logger.info(" Throwing ------ throwing:{}",  e.getMessage());
    }

    private class RequestLog {
        private String url;

        private String ip;

        private String classMethod;

        private Object[] args;

        public RequestLog(String url, String ip, String classMethod,
                Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog [url=" + url + ", ip=" + ip + ", classMethod="
                    + classMethod + ", args=" + Arrays.toString(args) + "]";
        }

    }
}
