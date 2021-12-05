package com.spring.jdbc.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BooksEntity {

    private int id;
    private String name;
    private double price;
    private int bookCount;
    private String author;

    public BooksEntity() {
    }

    public BooksEntity(int id, String name, double price, int bookCount, String author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.bookCount = bookCount;
        this.author = author;
    }

    public static String ID = "id";
    public static String NAME = "name";
    public static String PRICE = "price";
    public static String BOOK_COUNT = "bookCount";
    public static String AUTHOR = "author";


}
