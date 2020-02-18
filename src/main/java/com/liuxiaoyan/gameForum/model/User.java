package com.liuxiaoyan.gameForum.model;


import lombok.Data;

@Data
public class User {
    private Integer user_id;
    private String account_id;
    private String user_name;
    private Integer user_power;
    private String token;
    private Long gmt_create;
    private Long gmt_modified;
    private String head_url;
}
