package com.milman.action;

import com.milman.dataSource.ItemDao;
import com.milman.entity.Item;
import com.milman.entity.User;
import com.milman.util.UserUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;

public class EditItemAction extends ActionSupport {
    @Autowired
    private ItemDao itemDao;
    private Item item;
    private HttpServletRequest servletRequest;

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    @Override
    public String execute() throws Exception {
        User currentUser = UserUtil.getSessionUser();
        Long itemId = Long.valueOf(ServletActionContext.getRequest().getParameter("id"));
        if (currentUser != null) {
            setItem(itemDao.fetchById(itemId));
        }
        return SUCCESS;
    }
}
