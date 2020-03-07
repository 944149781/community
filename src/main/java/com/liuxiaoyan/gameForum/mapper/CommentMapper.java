package com.liuxiaoyan.gameForum.mapper;

import com.liuxiaoyan.gameForum.dto.CommentExDTO;
import com.liuxiaoyan.gameForum.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("insert into comment (parent_id,type,commentator,gmt_create,gmt_modified,content)" +
            "values(#{parent_id},#{type},#{commentator},#{gmt_create},#{gmt_modified},#{content})")
    void insert(Comment comment);

    @Select("select * from comment where parent_id = #{id} order by gmt_create DESC")
    List<CommentExDTO> listByPostId(Integer id);
}
