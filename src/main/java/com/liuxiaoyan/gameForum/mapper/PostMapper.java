package com.liuxiaoyan.gameForum.mapper;

import com.liuxiaoyan.gameForum.model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    @Insert("insert into post (title,description,creator,gmt_create,gmt_modified,tag)" +
            " values(#{title},#{description},#{creator},#{gmt_create},#{gmt_modified},#{tag})")
    void create(Post post);
}
