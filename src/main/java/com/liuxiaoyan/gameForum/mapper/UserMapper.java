package com.liuxiaoyan.gameForum.mapper;

import com.liuxiaoyan.gameForum.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert into user(user_name,account_id,token,gmt_create,gmt_modified,head_url)" +
            " values(#{user_name},#{account_id},#{token},#{gmt_create},#{gmt_modified},#{head_url})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where user_id = #{user_id}")
    User findById(@Param("user_id")Integer user_id);

    @Select("select * from user where account_id = #{account_id}")
    User findByAccountId(String account_id);

    @Update("update user set user_name = #{user_name},token = #{token},gmt_modified = #{gmt_modified},head_url = #{head_url} where user_id = #{user_id}")
    void update(User dbUser);

    @Select("select * from user")
    List<User> findAllUser();

    @Delete("delete from user where user_id = #{user_id}")
    void deleteById(Integer user_id);
}