package com.milman.action;

import com.milman.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class ProfileAction extends ActionSupport {
//    private User user;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public String execute() {
        String user = ServletActionContext.getRequest().getParameter("user");

//        this.user = (User)(Object) user;

        System.out.println(user);
        return SUCCESS;
    }
}
