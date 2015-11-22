package com.milman.dataSource.PostgresImpl;

import com.milman.dataSource.UserDao;
import com.milman.dataSource.mappers.UserMapper;
import com.milman.entity.User;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

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
    public User findByEmail(String email) {
        final String SQL = "SELECT * FROM USERS WHERE EMAIL=?";
        return getJdbcTemplate().queryForObject(SQL, new Object[]{email}, new UserMapper());
    }

    @Override
    public User findByCredentials(String email, String password) {
        final String SQL = "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";
        return getJdbcTemplate().queryForObject(
                SQL, new Object[]{email, password}, new UserMapper());
    }

    @Override
    public User insert(User user) {
        final String SQL = "INSERT INTO USERS (username, email, password) " +
                "VALUES (?, ?, ?)";
//        getJdbcTemplate().update(SQL, user.getUsername(),
//                                      user.getEmail(),
//                                      user.getPassword());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement pst =
                                con.prepareStatement(SQL, new String[]{"id"});
                        pst.setString(1, user.getUsername());
                        pst.setString(2, user.getEmail());
                        pst.setString(3, user.getPassword());
                        return pst;
                    }
                },
                keyHolder);
        Long id = keyHolder.getKey().longValue();
        user.setId(id);
        return user;
    }
}
