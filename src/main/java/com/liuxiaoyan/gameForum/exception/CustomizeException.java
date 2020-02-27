package com.liuxiaoyan.gameForum.exception;

public class CustomizeException extends RuntimeException {
    private String massage;

    public CustomizeException(ICustomizeError error){
        this.massage = error.getMessage();
    }

    public CustomizeException(String message){
        this.massage = message;
    }

    public String getMassage(){
        return massage;
    }
}
