package com.liuxiaoyan.gameForum.advice;


import com.liuxiaoyan.gameForum.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model){
        if (e instanceof CustomizeException){
            model.addAttribute("message",((CustomizeException) e).getMassage());
        }else {
            model.addAttribute("message","服务器繁忙，请稍后再试！");
        }
        return new ModelAndView("error");
    }
}
