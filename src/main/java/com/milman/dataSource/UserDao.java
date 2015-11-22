package com.milman.dataSource;

import com.milman.entity.User;

public interface UserDao {
    public boolean checkLogin(User user);

    public User findById(Long id);

    public User findByCredentials(String email, String password);

    public User findByEmail(String email);

    public User insert(User user);
}
