package com.liuxiaoyan.gameForum.mapper;

import com.liuxiaoyan.gameForum.model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {
    @Insert("insert into post (title,description,creator,gmt_create,gmt_modified,tag)" +
            " values(#{title},#{description},#{creator},#{gmt_create},#{gmt_modified},#{tag})")
    void create(Post post);

    @Select("select * from post limit #{offSet},#{size}")
    List<Post> list(Integer offSet, Integer size);

    @Select("select count(1) from post")
    Integer count();
}
