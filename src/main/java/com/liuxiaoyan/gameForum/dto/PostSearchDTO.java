package com.liuxiaoyan.gameForum.dto;

import lombok.Data;

@Data
public class PostSearchDTO {
    private String search;
    private Integer page;
    private Integer size;
}
