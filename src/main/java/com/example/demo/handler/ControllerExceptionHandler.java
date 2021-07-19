/*
 * created on Jul 16, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 16, 2021 $
 */
package com.example.demo.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler({Exception.class})//可傳多個{BookNotFoundException.class, SQLException.class}
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ModelAndView handleException(HttpServletRequest request, Exception e) throws Exception {
        e.printStackTrace();
        logger.error("Request URL : {}, Exception: {}", request.getRequestURL(), e.getMessage());

        //若是有自行宣告ResponseStatus則不處理，直接再往外拋ex:BookNotFoundException
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null) {
            throw e;
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("url",request.getRequestURL());
        mav.addObject("exception",e);
        mav.setViewName("error/error");
        return mav;
    }
    
//    @ExceptionHandler({BookNotFoundException.class, SQLException.class})
//    public ModelAndView handleOtherException(HttpServletRequest request, Exception e) throws Exception {
//        //not implement
//    }
    

}
