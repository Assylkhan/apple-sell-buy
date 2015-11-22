package com.milman.action;

import com.milman.dataSource.UserDao;
import com.milman.entity.User;
import com.milman.util.HashGenerator;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;
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
        String generatedPassword = HashGenerator.passwordToHash(user.getPassword());
        User userFromDb = userDao.findByCredentials(user.getEmail(), generatedPassword);
        ServletActionContext.getRequest().getSession().setAttribute("user", userFromDb);
        return SUCCESS;
//        }

//        return LOGIN;
    }

    @Override
    public void validate() {
        if (user.getEmail().length() == 0) {
            addActionError("Заполните имя пользователя");
//            addFieldError("user.username", "заполните поле");
        }

        if (user.getPassword().length() == 0) {
            addActionError("Заполните пароль");
//            addFieldError("user.password", "заполните поле");
        }
    }

    //This method will be called before any of Action method is invoked;
    //So some pre-processing if required.
    @Override
    public void prepare() throws Exception {

    }
}
