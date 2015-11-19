package com.milman.dataSource;

import com.milman.entity.User;

public interface UserDao {
    public boolean checkLogin(User user);

    public User findById(Long id);
}
