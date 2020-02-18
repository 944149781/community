package com.liuxiaoyan.gameForum.mapper;

import com.liuxiaoyan.gameForum.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user(user_name,account_id,token,gmt_create,gmt_modified,head_url)" +
            " values(#{user_name},#{account_id},#{token},#{gmt_create},#{gmt_modified},#{head_url})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where user_id = #{user_id}")
    User findById(@Param("user_id")Integer user_id);

}