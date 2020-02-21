package com.liuxiaoyan.gameForum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserCenterController {

    @GetMapping("/userCenter/{action}")
    public String userCenter(@PathVariable(name = "action") String action,
                             Model model){

        if ("myPosts".equals(action)){
            model.addAttribute("section","myPosts");
            model.addAttribute("sectionName","我的帖子");
        }else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","我的回复");
        }

        return "userCenter";
    }
}
