package com.milman.action;

import com.milman.dataSource.ItemDao;
import com.milman.entity.Item;
import com.milman.entity.User;
import com.milman.util.UserUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UserItemAction extends ActionSupport implements Preparable {

    @Autowired
    private ItemDao itemDao;

    public ItemDao getItemDao() {
        return itemDao;
    }

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String execute() {
        User currentUser = UserUtil.getSessionUser();
        String id = ServletActionContext.getRequest().getParameter("id");
        System.out.println(id);
        Long itemId = Long.valueOf(ServletActionContext.getRequest().getParameter("id"));
        setItem(itemDao.fetchById(itemId));
        return SUCCESS;
    }

    public String deleteMyItem() {
        User currentUser = UserUtil.getSessionUser();
        if (currentUser != null) {
            String itemId = ServletActionContext.getRequest().getParameter("id");
            itemDao.deleteById(new Long(itemId));
        }
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {

    }
}
