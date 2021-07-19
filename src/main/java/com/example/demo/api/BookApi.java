/*
 * created on Jul 16, 2021
 * 
 * $Author: jack98 $
 * $Revision: 1.0 $ 
 * $Date: Jul 16, 2021 $
 */
package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDTO;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookApi {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping("/books")
    public ResponseEntity<?> listAllBooks(){
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK) ;
    }
    
    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBook(@PathVariable Long id){
        Book book = bookService.getBookById(id);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    
    @PostMapping("/books")
    public ResponseEntity<?> saveBook(@RequestBody Book book){
        Book booksave = bookService.saveBook(book);
        return new ResponseEntity<Book>(booksave, HttpStatus.CREATED);
    }
    
    @PutMapping("/books/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        Book currentBook = bookService.getBookById(id);
        bookDTO.convertToBook(currentBook);
        Book book1 = bookService.updateBook(currentBook);
        return new ResponseEntity<Book>(book1, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping("/books")
    public ResponseEntity<?> deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
    
    
}
