package com.spring.jdbc.test.controller;

import com.spring.jdbc.test.entity.BooksEntity;
import com.spring.jdbc.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/queryForList")
    public List<BooksEntity> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/queryForNumber")
    public int getBooksNumber(){
        return bookService.getBooksNumber();
    }

    @GetMapping("/queryBooksMap")
    public Map<String,Object> getBooksMap(){
        return bookService.getBooksByJdbcTemplate();
    }



    @GetMapping("/queryBooksByName")
    public List<BooksEntity> getBooksByName(){
        return bookService.getBooksByName();
    }

    @GetMapping("/queryBooksByNamedParameterJdbcTemplate")
    public List<BooksEntity> getBooksByNamedParameterJdbcTemplate(){
        return bookService.getBooksByNamedParameterJdbcTemplate();
    }
}
