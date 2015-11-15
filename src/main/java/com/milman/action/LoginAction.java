package com.milman.action;

import com.milman.dataSource.UserDao;
import com.milman.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginAction extends ActionSupport implements Preparable {
    //UserDao injected by spring context; This is cool !!
    @Autowired
    private UserDao userDao;

    private User user;

    public void setUserDao(UserDao userDao) {
        this.userDao = this.userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String execute() {
//        if (userDao.checkLogin(user)) {

            return SUCCESS;
//        }

//        return LOGIN;
    }

    @Override
    public void validate() {
        if (user.getUsername().length() == 0) {
            addFieldError("user.username", "заполните поле");
        }

        if(user.getPassword().length() == 0) {
            addFieldError("user.password", "заполните поле");
        }
    }

    //This method will be called before any of Action method is invoked;
    //So some pre-processing if required.
    @Override
    public void prepare() throws Exception {

    }
}
