package com.milman.action;

import com.milman.dataSource.UserDao;
import com.milman.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private UserDao userDao;
    private User user;

    public void setUserDAO(UserDao userDAO) {
        this.userDao = userDao;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String execute() {
        if (userDao.checkLogin(user)) {
            return SUCCESS;
        }

        return ERROR;
    }
}
