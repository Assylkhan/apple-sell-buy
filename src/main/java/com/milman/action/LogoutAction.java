package com.milman.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class LogoutAction extends ActionSupport {
    public String execute(){
        ServletActionContext.getRequest().getSession().invalidate();
        return SUCCESS;
    }
}
