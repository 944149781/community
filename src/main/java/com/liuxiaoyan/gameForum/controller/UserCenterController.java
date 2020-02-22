package com.liuxiaoyan.gameForum.controller;


import com.liuxiaoyan.gameForum.dto.PageDTO;
import com.liuxiaoyan.gameForum.model.User;
import com.liuxiaoyan.gameForum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserCenterController {

    @Autowired
    private PostService postService;

    @GetMapping("/userCenter/{action}")
    public String userCenter(HttpServletRequest request,
                             @PathVariable(name = "action") String action,
                             Model model,
                             @RequestParam(name = "page", defaultValue = "1") Integer page,
                             @RequestParam(name = "size", defaultValue = "5") Integer size){

        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/";
        }

        if ("myPosts".equals(action)){
            model.addAttribute("section","myPosts");
            model.addAttribute("sectionName","我的帖子");
        }else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","我的回复");
        }
        PageDTO pageDTO = postService.listByUserId(user.getUser_id(),page,size);
        model.addAttribute("page",pageDTO);
        return "userCenter";
    }
}
