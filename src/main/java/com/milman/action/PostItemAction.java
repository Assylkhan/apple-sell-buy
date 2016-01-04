package com.milman.action;

import com.milman.dataSource.ItemDao;
import com.milman.dataSource.UserDao;
import com.milman.entity.Item;
import com.milman.entity.Media;
import com.milman.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostItemAction extends ActionSupport implements Preparable {
    //UserDao injected by spring context; This is cool !!
    @Autowired
    private ItemDao itemDao;

    public void setItemDao(ItemDao itemDao) {
        this.itemDao = this.itemDao;
    }

    public ItemDao getItemDao() {
        return itemDao;
    }

    private Item item;

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    private List<Media> medias;

    public List<Media> getMedias() {
        return medias;
    }

    public void setMedias(List<Media> medias) {
        this.medias = medias;
    }

    public String execute() {
//        if (itemDao.checkLogin(item)) {
//        )
        User user = (User) ServletActionContext.getRequest()
                    .getSession().getAttribute("user");
        item.setUser(user);
        Item itemFromDb = itemDao.insert(item);
        ServletActionContext.getRequest().setAttribute("flash.item", itemFromDb);
        return SUCCESS;
//        }
    }

    @Override
    public void validate() {
        if (item.getName().length() == 0) {
            addActionError("Заполните название товара");
//            addFieldError("item.username", "заполните поле");
        }

        if (item.getPrice().length() == 0) {
            addActionError("Заполните стоимость товара");
//            addFieldError("item.password", "заполните поле");
        }

        if (item.getDescription().length() == 0){
            addActionError("Заполните описание товара");
        }
    }

    //This method will be called before any of Action method is invoked;
    //So some pre-processing if required.
    @Override
    public void prepare() throws Exception {

    }
}