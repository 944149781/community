package com.liuxiaoyan.gameForum.controller;


import com.liuxiaoyan.gameForum.dto.CommentExDTO;
import com.liuxiaoyan.gameForum.dto.PostDTO;
import com.liuxiaoyan.gameForum.mapper.CommentMapper;
import com.liuxiaoyan.gameForum.mapper.PostMapper;
import com.liuxiaoyan.gameForum.model.Post;
import com.liuxiaoyan.gameForum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired(required = false)
    private CommentMapper commentMapper;

    @GetMapping("/post/{id}")
    public String post(@PathVariable(name = "id") Integer id,
                       Model model){
        PostDTO postDTO = postService.getById(id);
        List<PostDTO> postList = postService.selectRelated(postDTO);
        List<CommentExDTO> comments = commentMapper.listByPostId(id);

        postService.updateViewCount(id);
        model.addAttribute("post",postDTO);
        model.addAttribute("comment",comments);
        model.addAttribute("relatedPost",postList);
        return "post";
    }
}
