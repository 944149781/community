package com.liuxiaoyan.gameForum.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageDTO {
    private List<PostDTO> posts;
    private boolean showPrevious;
    private boolean showFirst;
    private boolean showNext;
    private boolean showEnd;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer allPage;

    public void setPage(Integer allPage, Integer page) {
        this.allPage = allPage;
        this.page = page;

        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= allPage) {
                pages.add(page + i);
            }
        }


        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        if (page == allPage) {
            showNext = false;
        } else {
            showNext = true;
        }
        if (pages.contains(1)) {
            showFirst = false;
        } else {
            showFirst = true;
        }
        if (pages.contains(allPage)) {
            showEnd = false;
        } else {
            showEnd = true;
        }
    }
}
