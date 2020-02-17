package com.liuxiaoyan.gameForum.model;

public class User {
    private Integer user_id;
    private String account_id;
    private String user_name;
    private Integer user_power;
    private String token;
    private Long gmt_create;
    private Long gmt_modified;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getUser_power() {
        return user_power;
    }

    public void setUser_power(Integer user_power) {
        this.user_power = user_power;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Long gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Long getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Long gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", account_id='" + account_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_power=" + user_power +
                ", token='" + token + '\'' +
                ", gmt_create=" + gmt_create +
                ", gmt_modified=" + gmt_modified +
                '}';
    }
}
