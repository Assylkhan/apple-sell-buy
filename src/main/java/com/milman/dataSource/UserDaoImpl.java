package com.milman.dataSource;

import com.milman.entity.User;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean checkLogin(User user) {
        return user.getUsername().equals("admin")
                && user.getPassword().equals("nimda");
    }
}
