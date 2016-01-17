package com.milman.action;

import com.milman.dataSource.ItemDao;
import com.milman.entity.Item;
import com.milman.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.List;

public class UserItemsAction extends ActionSupport implements Preparable {

    @Autowired
    private ItemDao itemDao;

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String execute() {
        User currentUser = (User)
                ServletActionContext.getContext().getSession().get("user");
        if (currentUser != null) {
            setItems(itemDao.fetchListByUserId(currentUser.getId()));
        }
        URL resource1 = ServletActionContext.getRequest().getClass().getResource("/10.png");
        ServletActionContext.getRequest().setAttribute("image", resource1);
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {

    }
}
