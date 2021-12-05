package com.spring.jdbc.test.controller;

import com.spring.jdbc.test.entity.BooksEntity;
import com.spring.jdbc.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("query")
    public List<BooksEntity> getBooksNumber(){
        return bookService.getBookNumber();
    }
}
