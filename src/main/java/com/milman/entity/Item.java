package com.milman.entity;

import java.io.Serializable;
import java.sql.Date;

public class Item extends BaseEntity implements Serializable {
    private String name;
    private String price;
    private Date publicationDate;

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
}
