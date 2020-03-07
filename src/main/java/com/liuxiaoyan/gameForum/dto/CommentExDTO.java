package com.liuxiaoyan.gameForum.dto;

import lombok.Data;

@Data
public class CommentExDTO {
    private Integer id;
    private Integer parent_id;
    private Integer type;
    private Integer commentator;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer like_count;
    private String content;
}
