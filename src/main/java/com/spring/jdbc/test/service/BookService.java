package com.spring.jdbc.test.service;

import com.spring.jdbc.test.converter.BooksEntityConverter;
import com.spring.jdbc.test.converter.DataBaseEntityConverter;
import com.spring.jdbc.test.entity.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public  <T> List<BooksEntity> getBookNumber(){
        DataBaseEntityConverter<BooksEntity> converter = new BooksEntityConverter();
        List<BooksEntity> res =  namedParameterJdbcTemplate.query("select * from books;" ,
               (rs,rowNum) -> converter.toInstance(rs));
        System.out.println(res);

        return  res;
    }

}
