package com.milman.entity;

import java.sql.Date;
import java.util.List;

public class User extends BaseEntity {
    private String username;
    private String email;
    private String identityCard;
    private List<String> identityCardImages;
    private String password;
    private Date registrationDate;
    private String phoneNumber;
    private Byte rating;
    private List<String> feedbacks;
    private List<Item> items;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public List<String> getIdentityCardImages() {
        return identityCardImages;
    }

    public void setIdentityCardImages(List<String> identityCardImages) {
        this.identityCardImages = identityCardImages;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Byte getRating() {
        return rating;
    }

    public void setRating(Byte rating) {
        this.rating = rating;
    }

    public List<String> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<String> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", identityCardImages=" + identityCardImages +
                ", password='" + password + '\'' +
                ", registrationDate=" + registrationDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", rating=" + rating +
                ", feedbacks=" + feedbacks +
                ", items=" + items +
                '}';
    }
}
