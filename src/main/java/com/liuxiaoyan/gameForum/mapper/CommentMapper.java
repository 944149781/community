package com.liuxiaoyan.gameForum.mapper;

import com.liuxiaoyan.gameForum.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    @Insert("insert into comment (parent_id,type,commentator,gmt_create,gmt_modified,content)" +
            "values(#{parent_id},#{type},#{commentator},#{gmt_create},#{gmt_modified},#{content})")
    void insert(Comment comment);
}
