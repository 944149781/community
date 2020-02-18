package com.liuxiaoyan.gameForum.dto;

import com.liuxiaoyan.gameForum.model.User;
import lombok.Data;

@Data
public class PostDTO {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmt_create;
    private Long gmt_modified;
    private Integer creator;
    private Integer comment_count;
    private Integer view_count;
    private Integer like_count;
    private User user;
}
