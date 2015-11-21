package com.milman.dataSource.PostgresImpl;

import com.milman.dataSource.UserDao;
import com.milman.dataSource.UserMapper;
import com.milman.entity.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
    final String SELECT_USER_BY_ID = "SELECT * FROM USERS WHERE ID=?";

    @Override
    public boolean checkLogin(User user) {
        return user.getUsername().equals("admin")
                && user.getPassword().equals("nimda");
    }

    public User findById(Long id) {
        final String SQL = "SELECT * FROM USERS WHERE ID=?";
        return getJdbcTemplate().queryForObject(SQL, new Object[]{id}, new UserMapper());
    }

    @Override
    public User findByCredentials(String email, String password) {
        final String SQL = "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";
        return getJdbcTemplate().queryForObject(SQL, new Object[]{email, password}, new UserMapper());
    }

    @Override
    public User insert(User user) {
        final String SQL = "INSERT INTO USERS ";
        return getJdbcTemplate().queryForObject(SQL,
                new Object[]{user.getUsername(),
                             user.getEmail(),
                             user.getPassword()}, new UserMapper());
    }
}
