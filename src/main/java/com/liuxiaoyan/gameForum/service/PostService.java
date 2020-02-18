package com.liuxiaoyan.gameForum.service;


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

    public List<PostDTO> list() {
        List<Post> postList = postMapper.list();
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post:postList){
            User user = userMapper.findById(post.getCreator());
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post,postDTO);
            postDTO.setUser(user);
            postDTOList.add(postDTO);
        }
        return postDTOList;
    }
}
