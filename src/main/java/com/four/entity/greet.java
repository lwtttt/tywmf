package com.four.entity;

public class greet {
    private int greetId;
    private String userName;
    private String greetByWho;
    private String greetStatus;

    public greet() {
    }

    public greet(int greetId, String userName, String greetByWho, String greetStatus) {
        this.greetId = greetId;
        this.userName = userName;
        this.greetByWho = greetByWho;
        this.greetStatus = greetStatus;
    }

    @Override
    public String toString() {
        return "greet{" +
                "greetId=" + greetId +
                ", userName='" + userName + '\'' +
                ", greetByWho='" + greetByWho + '\'' +
                ", greetStatus='" + greetStatus + '\'' +
                '}';
    }

    public int getGreetId() {
        return greetId;
    }

    public void setGreetId(int greetId) {
        this.greetId = greetId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGreetByWho() {
        return greetByWho;
    }

    public void setGreetByWho(String greetByWho) {
        this.greetByWho = greetByWho;
    }

    public String getGreetStatus() {
        return greetStatus;
    }

    public void setGreetStatus(String greetStatus) {
        this.greetStatus = greetStatus;
    }
}
