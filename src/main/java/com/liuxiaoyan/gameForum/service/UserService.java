package com.liuxiaoyan.gameForum.service;


import com.liuxiaoyan.gameForum.mapper.UserMapper;
import com.liuxiaoyan.gameForum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;


    public void createOrUpdate(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccount_id());
        if (dbUser == null){
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modified(user.getGmt_create());
            userMapper.insert(user);
        }else {
            dbUser.setGmt_modified(System.currentTimeMillis());
            dbUser.setHead_url(user.getHead_url());
            dbUser.setUser_name(user.getUser_name());
            dbUser.setToken(user.getToken());
            userMapper.update(dbUser);
        }
    }
}
