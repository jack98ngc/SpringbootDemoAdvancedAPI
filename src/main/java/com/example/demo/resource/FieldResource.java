/*
 * created on Jul 19, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 19, 2021 $
 */
package com.example.demo.resource;

public class FieldResource {
    private String recource;
    private String field;
    private String code;
    private String message;
    public FieldResource(String recource, String field, String code,
            String message) {
        this.recource = recource;
        this.field = field;
        this.code = code;
        this.message = message;
    }
    public String getRecource() {
        return recource;
    }
    public String getField() {
        return field;
    }
    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

    
}
