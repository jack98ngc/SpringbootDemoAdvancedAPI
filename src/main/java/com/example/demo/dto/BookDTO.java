/*
 * created on Jul 19, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 19, 2021 $
 */
package com.example.demo.dto;

import org.springframework.beans.BeanUtils;

import com.example.demo.domain.Book;
import com.example.demo.util.CustomBeanUtils;

public class BookDTO {

    private String author;
    private String description;
    private String name;
    private Integer status;
    public BookDTO() {    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public void convertToBook(Book book) {
        new BookConvert().convert(BookDTO.this, book);
    }
    
    private class BookConvert implements Convert<BookDTO, Book>{

        @Override
        public Book convert(BookDTO dto, Book book) {
            BeanUtils.copyProperties(dto,book, CustomBeanUtils.getNullPropertyNames(dto));
            return book;
        }

        @Override
        public Book convert(BookDTO s) {
            return null;
        }
        
        
    }
    
}
