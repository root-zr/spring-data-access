package com.spring.jdbc.test.converter;


import java.sql.ResultSet;

public interface DataBaseEntityConverter<T> {
    T toInstance(ResultSet rs);
}
