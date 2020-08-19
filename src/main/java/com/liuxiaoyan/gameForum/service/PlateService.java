package com.liuxiaoyan.gameForum.service;

import com.liuxiaoyan.gameForum.mapper.PlateMapper;
import com.liuxiaoyan.gameForum.model.Plate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateService {
    @Autowired(required = false)
    private PlateMapper plateMapper;

    public void deleteById(Integer plate_id){
        plateMapper.deleteById(plate_id);
    }

    public void insertPlate(Plate plate){
        plate.setGmt_create(System.currentTimeMillis());
        plate.setGmt_modified(plate.getGmt_create());
        plateMapper.insertPlate(plate);
    }

    public void updatePlate(Plate plate){
        plate.setGmt_modified(System.currentTimeMillis());
        plateMapper.updatePlate(plate);
    }
}
