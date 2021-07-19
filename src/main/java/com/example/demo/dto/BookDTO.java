/*
 * created on Jul 19, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 19, 2021 $
 */
package com.example.demo.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import com.example.demo.domain.Book;
import com.example.demo.util.CustomBeanUtils;

public class BookDTO {

    @NotBlank
    private String author;
    @Length(max=20)
    private String description;
    @NotBlank
    private String name;
    @NotNull
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

    public Book convertToBook() {
        return new BookConvert().convert(BookDTO.this);
    }
    
    private class BookConvert implements Convert<BookDTO, Book>{

        @Override
        public Book convert(BookDTO dto, Book book) {
            BeanUtils.copyProperties(dto,book, CustomBeanUtils.getNullPropertyNames(dto));
            return book;
        }

        @Override
        public Book convert(BookDTO s) {
            Book book = new Book();
            BeanUtils.copyProperties(BookDTO.this, book);
            return book;
        }
        
        
    }
    
}
