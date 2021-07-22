/*
 * created on Jul 19, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 19, 2021 $
 */
package com.example.demo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping("/log")
    public String log() {
        
        String name = "zhang";
        String email = "hell@111.com";
        logger.error("-------- log ------------");
//        logger.error("error --- log");
//        logger.warn("warn --- log");
//        logger.info("info --- log");
//        logger.debug("debug--- log");
//        logger.trace("trace--- log");
//        logger.info("name : {}, email : {}", name, email);
        return "log-list";
    }
}
