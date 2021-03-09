package com.four.entity;

public class browse {

    private int userId;
    private String userName;
    private String browseWho;

    public browse() {
    }

    public browse(int userId, String userName, String browseWho) {
        this.userId = userId;
        this.userName = userName;
        this.browseWho = browseWho;
    }

    @Override
    public String toString() {
        return "browse{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", browseWho='" + browseWho + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBrowseWho() {
        return browseWho;
    }

    public void setBrowseWho(String browseWho) {
        this.browseWho = browseWho;
    }
}
