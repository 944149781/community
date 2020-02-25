package com.liuxiaoyan.gameForum.service;


import com.liuxiaoyan.gameForum.dto.PageDTO;
import com.liuxiaoyan.gameForum.dto.PostDTO;
import com.liuxiaoyan.gameForum.mapper.PostMapper;
import com.liuxiaoyan.gameForum.mapper.UserMapper;
import com.liuxiaoyan.gameForum.model.Post;
import com.liuxiaoyan.gameForum.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private PostMapper postMapper;

    public PageDTO list(Integer page, Integer size) {

        PageDTO pageDTO = new PageDTO();

        Integer allPage;

        Integer allCount = postMapper.count();

        if (allCount % size ==0){
            allPage = allCount/size;
        }else {
            allPage = allCount/size + 1;
        }

        if (page < 1){
            page = 1;
        }
        if (page > allPage){
            page = allPage;
        }

        pageDTO.setPage(allPage,page);
        Integer offSet = size * (page - 1);

        List<Post> postList = postMapper.list(offSet, size);
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : postList) {
            User user = userMapper.findById(post.getCreator());
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post, postDTO);
            postDTO.setUser(user);
            postDTOList.add(postDTO);
        }
        pageDTO.setPosts(postDTOList);
        return pageDTO;
    }
    public PageDTO listByUserId(Integer user_id,Integer page,Integer size){
        PageDTO pageDTO = new PageDTO();
        Integer allCount = postMapper.countByUserId(user_id);
        Integer allPage;


        if (allCount % size ==0){
            allPage = allCount/size;
        }else {
            allPage = allCount/size + 1;
        }

        if (page < 1){
            page = 1;
        }
        if (page > allPage){
            page = allPage;
        }

        pageDTO.setPage(allPage,page);
        Integer offSet = size * (page - 1);

        List<Post> postList = postMapper.listByUserId(user_id,offSet, size);
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : postList) {
            User user = userMapper.findById(post.getCreator());
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post, postDTO);
            postDTO.setUser(user);
            postDTOList.add(postDTO);
        }
        pageDTO.setPosts(postDTOList);
        return pageDTO;
    }

    public PostDTO getById(Integer id) {
        Post post = postMapper.getById(id);
        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(post, postDTO);
        User user = userMapper.findById(post.getCreator());
        postDTO.setUser(user);
        return postDTO;
    }
}
