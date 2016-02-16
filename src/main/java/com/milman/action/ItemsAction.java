package com.milman.action;

import com.milman.dataSource.ItemDao;
import com.milman.entity.Item;
import com.milman.entity.User;
import com.milman.util.UserUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.List;

public class ItemsAction extends ActionSupport implements Preparable, ServletRequestAware {
    private HttpServletRequest servletRequest;
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

    @Override
    public String execute() throws Exception {
        String searchText = servletRequest.getParameter("searchText");
        if (searchText == null) {
            setItems(itemDao.fetchList());
        } else {
            setItems(itemDao.fetchByName(searchText));
        }
        servletRequest.setAttribute("searchText", searchText);
        return SUCCESS;
    }

    public String userItems() throws Exception {
        User currentUser = UserUtil.getSessionUser();
        if (currentUser != null) {
            setItems(itemDao.fetchListByUserId(currentUser.getId()));
        }
        URL resource1 = ServletActionContext.getRequest().getClass().getResource("/10.png");
        servletRequest.setAttribute("image", resource1);
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {

    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        servletRequest = httpServletRequest;
    }
}
