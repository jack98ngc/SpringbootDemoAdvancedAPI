/*
 * created on Jul 19, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 19, 2021 $
 */
package com.example.demo.dto;

public interface Convert <S, T>{
    T convert(S s, T t);
    T convert(S s);
}
