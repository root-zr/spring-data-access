package test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestApi {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test(){
        int list = jdbcTemplate.queryForObject("select Count( * ) from books;", Integer.class);
        System.out.println(list);
    }
}
