package com.spring.jdbc.test.converter;

import com.spring.jdbc.test.entity.BooksEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.spring.jdbc.test.entity.BooksEntity.*;

@Component
@RequiredArgsConstructor
public class BooksEntityConverter implements DataBaseEntityConverter<BooksEntity> {
    private static final Logger logger =  LoggerFactory.getLogger(BooksEntityConverter.class);

    @Override
    public BooksEntity toInstance(ResultSet rs) {

        try{
            return BooksEntity.builder()
                    .id(rs.getInt(ID))
                    .author(rs.getString(AUTHOR))
                    .bookCount(rs.getInt(BOOK_COUNT))
                    .name(rs.getString(NAME))
                    .price(rs.getDouble(PRICE))
                    .build();

        } catch (SQLException e) {
            logger.error("instance error!");
            return null;
        }
    }
}
