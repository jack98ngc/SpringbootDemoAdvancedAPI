/*
 * created on Jul 19, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 19, 2021 $
 */
package com.example.demo.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.InvalidRequestException;
import com.example.demo.resource.ErrorResource;
import com.example.demo.resource.FieldResource;
import com.example.demo.resource.InvalidErrorResource;

@RestControllerAdvice
public class ApiExceptionHandler {
    
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handleNotFound(RuntimeException e){
        ErrorResource errorResource = new ErrorResource(e.getMessage());
        return new ResponseEntity<Object>( errorResource, HttpStatus.NOT_FOUND);
    }
    
    
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseBody
    public ResponseEntity<?> handleInvalidRequest(InvalidRequestException e){
        List<FieldResource> fieldResources = new ArrayList<FieldResource>();
        List<FieldError> fieldErrors = e.getErrors().getFieldErrors();
        for(FieldError err : fieldErrors) {
            FieldResource fieldResource = new FieldResource(err.getObjectName(), err.getField(), err.getCode(), err.getDefaultMessage());
                    fieldResources.add(fieldResource);
        }
        InvalidErrorResource ier = new InvalidErrorResource(e.getMessage(), fieldResources);
        return new ResponseEntity<Object>(ier, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(Exception e){
        return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
}
