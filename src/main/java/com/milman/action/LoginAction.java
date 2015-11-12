package com.milman.action;

import com.milman.dataSource.UserDao;
import com.milman.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.DefaultActionSupport;

public class LoginAction extends DefaultActionSupport {
    private UserDao userDao;
    private User user;

    public void setUserDao(UserDao userDao) {
        this.userDao = this.userDao;
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
