package com.liuxiaoyan.gameForum.service;


import com.liuxiaoyan.gameForum.dto.PageDTO;
import com.liuxiaoyan.gameForum.dto.PostDTO;
import com.liuxiaoyan.gameForum.exception.CustomizeError;
import com.liuxiaoyan.gameForum.exception.CustomizeException;
import com.liuxiaoyan.gameForum.mapper.PostMapper;
import com.liuxiaoyan.gameForum.mapper.UserMapper;
import com.liuxiaoyan.gameForum.model.Post;
import com.liuxiaoyan.gameForum.model.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        if (post == null){
            throw new CustomizeException(CustomizeError.POST_NOT_FOUND);
        }
        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(post, postDTO);
        User user = userMapper.findById(post.getCreator());
        postDTO.setUser(user);
        return postDTO;
    }

    public void createOrUpdate(Post post) {
        if (post.getId() == null){
            post.setGmt_create(System.currentTimeMillis());
            post.setGmt_modified(post.getGmt_create());
            postMapper.create(post);
        }else {
            post.setGmt_modified(System.currentTimeMillis());
            postMapper.update(post);
        }
    }

    public void updateViewCount(Integer id) {
        postMapper.updateViewCount(id);
    }

    public List<PostDTO> selectRelated(PostDTO postDTO) {
        String[] tags = StringUtils.split(postDTO.getTag(),",");
        String regexpTag = Arrays.stream(tags).collect(Collectors.joining("|"));
        Post post = new Post();
        post.setId(postDTO.getId());
        post.setTag(regexpTag);

        List<Post> posts = postMapper.selectRelated(post);
        List<PostDTO> postDTOS = posts.stream().map(p -> {
            PostDTO postDTO1 = new PostDTO();
            BeanUtils.copyProperties(p,postDTO1);
            return postDTO1;
        }).collect(Collectors.toList());
        return postDTOS;
    }
}
