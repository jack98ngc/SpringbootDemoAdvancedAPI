/*
 * created on Jul 19, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 19, 2021 $
 */
package com.example.demo.resource;

public class InvalidErrorResource {
    private String message;
    private Object errors;
    public InvalidErrorResource(String message, Object errors) {
        this.message = message;
        this.errors = errors;
    }
    public String getMessage() {
        return message;
    }
    public Object getErrors() {
        return errors;
    }
    
}
