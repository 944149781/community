package com.liuxiaoyan.gameForum.model;

import lombok.Data;

@Data
public class Plate {
    private Integer plate_id;
    private String plate_name;
    private Long gmt_create;
    private Long gmt_modified;
}
