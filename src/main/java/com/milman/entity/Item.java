package com.milman.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Item extends BaseEntity implements Serializable {
    private String name;
    private String price;
    private Date publicationDate;
    private String description;
    private List<MediaForItem> mediaForItems;
    private Byte viewsAmount;
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MediaForItem> getMediaForItems() {
        return mediaForItems;
    }

    public void setMediaForItems(List<MediaForItem> mediaForItems) {
        this.mediaForItems = mediaForItems;
    }

    public Byte getViewsAmount() {
        return viewsAmount;
    }

    public void setViewsAmount(Byte viewsAmount) {
        this.viewsAmount = viewsAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
