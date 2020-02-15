package com.liuxiaoyan.gameForum.mapper;

import com.liuxiaoyan.gameForum.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    @Insert("insert into user(user_name,account_id,token,gmt_create,gmt_modified)" +
            " values(#{userName},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    public void insert(User user);
}
