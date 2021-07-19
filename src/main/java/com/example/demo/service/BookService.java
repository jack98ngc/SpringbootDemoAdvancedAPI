/*
 * created on May 23, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: May 23, 2021 $
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Book;

public interface BookService {

    List<Book> findAllBooks();
    Book getBookById(Long id);
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBookById(Long id);
    void deleteAllBooks();
}
