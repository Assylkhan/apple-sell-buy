package com.milman.dataSource.mappers;

import com.milman.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("ID"));
        user.setEmail(resultSet.getString("EMAIL"));
        user.setUsername(resultSet.getString("USERNAME"));
        user.setPassword(resultSet.getString("PASSWORD"));
//        user.setIdentityCard(resultSet.getString(""));
        return user;
    }
}
