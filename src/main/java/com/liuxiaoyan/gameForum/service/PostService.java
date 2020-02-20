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
        Integer offSet = size * (page - 1);

        List<Post> postList = postMapper.list(offSet, size);
        List<PostDTO> postDTOList = new ArrayList<>();
        PageDTO pageDTO = new PageDTO();
        for (Post post : postList) {
            User user = userMapper.findById(post.getCreator());
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(post, postDTO);
            postDTO.setUser(user);
            postDTOList.add(postDTO);
        }
        pageDTO.setPosts(postDTOList);
        Integer allCount = postMapper.count();
        pageDTO.setPage(allCount,page,size);
        return pageDTO;
    }
}
