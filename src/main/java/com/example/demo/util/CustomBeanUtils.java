/*
 * created on Jul 16, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 16, 2021 $
 */
package com.example.demo.util;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

public class CustomBeanUtils {
    public static String[] getNullPropertyNames(Object obj){
        List<String> results = new ArrayList<String>();
        BeanWrapper beanWrapper = new BeanWrapperImpl(obj);
        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
        
        for(PropertyDescriptor descriptor : Arrays.asList(propertyDescriptors)) {
            if(StringUtils.isEmpty(beanWrapper.getPropertyValue(descriptor.getName()))) {
                results.add(descriptor.getName());
            }
        }
        return results.toArray(new String[] {});
    }
}
