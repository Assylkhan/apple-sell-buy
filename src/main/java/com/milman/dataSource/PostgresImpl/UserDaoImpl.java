package com.milman.dataSource.PostgresImpl;

import com.milman.dataSource.CustomDataSource;
import com.milman.dataSource.UserDao;
import com.milman.entity.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    final String SELECT_USER_BY_ID = "SELECT * FROM USERS WHERE ID=?";

    @Override
    public boolean checkLogin(User user) {
        return user.getUsername().equals("admin")
                && user.getPassword().equals("nimda");
    }

    public User findById(Long id) {
        final String SQL = "SELECT * FROM USERS WHERE ID=?";
        return getJdbcTemplate().queryForObject(SQL, new Object[]{id}, new UsersMapper());
        return null;
    }
}
