package com.milman.util;

import com.milman.entity.User;
import org.apache.struts2.ServletActionContext;

public class UserUtil {
    public static User getSessionUser() {
        User user = (User) ServletActionContext.getRequest()
                .getSession().getAttribute("user");
        return user;
    }
}
