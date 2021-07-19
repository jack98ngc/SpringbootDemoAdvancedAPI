/*
 * created on Jul 16, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 16, 2021 $
 */
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    
    
    @Override
    public Book getBookById(Long id) {
        
      Book book = bookRepository.findOne(id);
        return book;
    }


    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    

}
