package com.spring.jdbc.test.service;

import com.spring.jdbc.test.converter.BooksEntityConverter;
import com.spring.jdbc.test.converter.DataBaseEntityConverter;
import com.spring.jdbc.test.entity.BooksEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class BookService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public  <T> List<BooksEntity> getBooks(){
        DataBaseEntityConverter<BooksEntity> converter = new BooksEntityConverter();
        List<BooksEntity> res =  namedParameterJdbcTemplate.query("select * from books;" ,
               (rs,rowNum) -> converter.toInstance(rs));

        log.info("books list is {}",res.toArray());

        return  res;
    }


    public int getBooksNumber(){
        int number = jdbcTemplate.queryForObject("select Count( * ) from books;", Integer.class);
        log.info("books number is {}",number);

        return number;
    }

    public Map<String,Object> getBooksByJdbcTemplate(){
        Map<String,Object> map = jdbcTemplate.queryForMap("select * from books LIMIT 1;" );
        log.info("books map is {}",map);

        return map;
    }

    public  List<BooksEntity> getBooksByNamedParameterJdbcTemplate(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("name","西游记");
//        map.put("author","吴承恩");
//
//        List<BooksEntity> list = namedParameterJdbcTemplate.query("select * from books where name = :name and author = :author ;",
//                map,new BeanPropertyRowMapper<>(BooksEntity.class));

//       也可以用下面的方式实现
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("name","西游记")
                .addValue("author","吴承恩");

        List<BooksEntity> list = namedParameterJdbcTemplate.query("select * from books where name = :name and author = :author ;",
                sqlParameterSource,new BeanPropertyRowMapper<>(BooksEntity.class));

        log.info("books  is {}",list);

        return list;
    }


    public  List<BooksEntity> getBooksByName(){
        List<BooksEntity> list = jdbcTemplate.query("select * from books where name = ? and author = ? ;",
                new Object[]{"西游记","吴承恩"},new BeanPropertyRowMapper<>(BooksEntity.class));

        log.info("books  is {}",list);

        return list;
    }

}
