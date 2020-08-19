package com.liuxiaoyan.gameForum.mapper;

import com.liuxiaoyan.gameForum.dto.PostDTO;
import com.liuxiaoyan.gameForum.dto.PostSearchDTO;
import com.liuxiaoyan.gameForum.model.Post;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select("select * from post where creator=#{user_id} limit #{offSet},#{size}")
    List<Post> listByUserId(Integer user_id, Integer offSet, Integer size);

    @Select("select count(1) from post where creator=#{user_id}")
    Integer countByUserId(Integer user_id);

    @Select("select * from post where id=#{id}")
    Post getById(Integer id);

    @Update("update post set title = #{title},description = #{description},gmt_modified = #{gmt_modified},tag = #{tag} where id = #{id}")
    void update(Post post);

    @Update("update post set view_count = view_count + 1 where id = #{id}")
    void updateViewCount(Integer id);

    @Update("update post set comment_count = comment_count + 1 where id = #{id}")
    void incCommentCount(Post post);

    @Select("select * from post where id != #{id} and tag regexp #{tag} limit 5")
    List<Post> selectRelated(Post post);

    @Select("select count(*) from post where title regexp #{search}")
    Integer countBySearch(PostSearchDTO postSearchDTO);

    @Select("select * from post where title regexp #{search} order by gmt_create desc limit #{page},#{size}")
    List<Post> selectBySearch(PostSearchDTO postSearchDTO);

    @Select("select * from post ORDER BY view_count desc limit 5")
    List<PostDTO> getHotList();
}
