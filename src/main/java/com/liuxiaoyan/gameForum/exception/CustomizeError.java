package com.liuxiaoyan.gameForum.exception;

public class CustomizeError implements ICustomizeError{

    public static final String POST_NOT_FOUND = "你所访问的页面已经不在了！！";

    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    CustomizeError(String message){
        this.message = message;
    }
}
