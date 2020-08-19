package com.liuxiaoyan.gameForum.mapper;

import com.liuxiaoyan.gameForum.model.Plate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PlateMapper {
    @Insert("insert into plate(plate_name,gmt_create,gmt_modified) values (#{plate_name},#{gmt_create},#{gmt_modified})")
    void insertPlate(Plate plate);

    @Update("update plate set plate_name = #{plate_name},gmt_modified = #{gmt_modified} where plate_id = #{plate_id}")
    void updatePlate(Plate plate);

    @Delete("delete from plate where plate_id = #{plate_id}")
    void deleteById(Integer plate_id);

    @Select("select * from plate")
    List<Plate> findAllPlate();

    @Select("select count(*) from plate")
    Integer plateCount();
}
