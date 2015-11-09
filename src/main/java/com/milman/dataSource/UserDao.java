package com.milman.dataSource;

import com.milman.entity.User;

public class UserDao {
    public boolean checkLogin(User user) {
        return user.getUsername().equals("admin")
                && user.getPassword().equals("nimda");
    }
}
