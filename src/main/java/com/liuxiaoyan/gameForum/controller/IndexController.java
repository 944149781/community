package com.liuxiaoyan.gameForum.controller;

import com.liuxiaoyan.gameForum.dto.PageDTO;
import com.liuxiaoyan.gameForum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired(required = false)
    private PostService postService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
        PageDTO pageDTO = postService.list(page,size);
        model.addAttribute("pageDTO", pageDTO);
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(name = "page", defaultValue = "1") Integer page,
                         @RequestParam(name = "size", defaultValue = "5") Integer size,
                         @RequestParam(name = "search") String search){

        PageDTO pageDTO = postService.listSearch(search,page,size);
        model.addAttribute("pageDTO",pageDTO);
        model.addAttribute("search",search);
        return "index";
    }
}
