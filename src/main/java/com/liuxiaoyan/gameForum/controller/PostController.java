package com.liuxiaoyan.gameForum.controller;


import com.liuxiaoyan.gameForum.dto.PostDTO;
import com.liuxiaoyan.gameForum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/{id}")
    public String post(@PathVariable(name = "id") Integer id,
                       Model model){
        PostDTO postDTO = postService.getById(id);
        model.addAttribute("post",postDTO);
        return "post";
    }
}
