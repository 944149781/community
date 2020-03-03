package com.liuxiaoyan.gameForum.controller;

import com.liuxiaoyan.gameForum.dto.CommentDTO;
import com.liuxiaoyan.gameForum.mapper.CommentMapper;
import com.liuxiaoyan.gameForum.mapper.PostMapper;
import com.liuxiaoyan.gameForum.model.Comment;
import com.liuxiaoyan.gameForum.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
public class CommentController {
    @Autowired(required = false)
    private CommentMapper commentMapper;

    @Autowired(required = false)
    private PostMapper postMapper;

    @ResponseBody
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object commentPost(@RequestBody CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setParent_id(commentDTO.getParent_id());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setCommentator(17);
        comment.setGmt_create(System.currentTimeMillis());
        comment.setGmt_modified(System.currentTimeMillis());
        System.out.println(comment.toString());
        commentMapper.insert(comment);
        Post post = postMapper.getById(comment.getParent_id());
        postMapper.incCommentCount(post);
        return null;
    }
}
