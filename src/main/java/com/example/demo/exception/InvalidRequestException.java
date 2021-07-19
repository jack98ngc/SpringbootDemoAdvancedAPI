/*
 * created on Jul 19, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 19, 2021 $
 */
package com.example.demo.exception;

import org.springframework.validation.Errors;

public class InvalidRequestException extends RuntimeException {
    private Errors errors;

    public InvalidRequestException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }

    
}
