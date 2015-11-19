package com.milman.dataSource;

import com.milman.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;

public class UserDaoImpl implements UserDao {
    final String SELECT_USER_BY_ID = "SELECT * FROM USERS WHERE ID=?";

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean checkLogin(User user) {
        return user.getUsername().equals("admin")
                && user.getPassword().equals("nimda");
    }

    public User findById(Long id) {
        Connection conn = null;
        return null;
    }
}
