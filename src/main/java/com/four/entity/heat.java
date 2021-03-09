package com.four.entity;

public class heat {
    private int userId;
    private String userName;
    private String focusUserName;

    public heat() {
    }

    public heat(int userId, String userName, String focusUserName) {
        this.userId = userId;
        this.userName = userName;
        this.focusUserName = focusUserName;
    }

    @Override
    public String toString() {
        return "heat{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", focusUserName='" + focusUserName + '\'' +
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

    public String getFocusUserName() {
        return focusUserName;
    }

    public void setFocusUserName(String focusUserName) {
        this.focusUserName = focusUserName;
    }
}
