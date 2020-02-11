package com.liuxiaoyan.gameForum.model;

public class User {
    private Integer id;
    private String userName;
    private String userPass;
    private Integer userPower;
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Integer getUserPower() {
        return userPower;
    }

    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
