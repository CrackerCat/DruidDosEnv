package com.example.druid;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    final
    JdbcTemplate jdbcTemplate;

    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) {
        jdbcTemplate.update("insert into user (username,address) values (?,?);",
                user.getUsername(), user.getAddress());
    }

    public String selectUser(String conditionKey, String conditionValue) {
        String sql = "select * from user where " + conditionKey + " RLIKE " + conditionValue;
        System.out.println(sql);
        List<User> users =  jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));

        StringBuilder sb = new StringBuilder();
        for(User user:users){
            sb.append("<p>");
            sb.append(user.getId()).append("\t");
            sb.append(user.getUsername()).append("\t");
            sb.append(user.getAddress()).append("\t");
            sb.append("</p>");
        }
        return sb.toString();
    }
}