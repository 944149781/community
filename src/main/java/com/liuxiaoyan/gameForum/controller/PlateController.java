package com.liuxiaoyan.gameForum.controller;


import com.liuxiaoyan.gameForum.mapper.PlateMapper;
import com.liuxiaoyan.gameForum.model.Plate;
import com.liuxiaoyan.gameForum.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Transactional
public class PlateController {
    @Autowired(required = false)
    private PlateService plateService;

    @Autowired(required = false)
    private PlateMapper plateMapper;

    @GetMapping("/plate")
    public String editPlate(Model model){
        List<Plate> plates = plateMapper.findAllPlate();
        model.addAttribute("plates",plates);
        return "editPlate";
    }

    @GetMapping("/deletePlate/{plate_id}")
    public String deleteById(@PathVariable(name = "plate_id") Integer plate_id){
        plateService.deleteById(plate_id);
        return "redirect:/plate";
    }

    @ResponseBody
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String updatePlate(@RequestBody Plate plate){
        Plate plate1 = new Plate();
        plate1.setPlate_name(plate.getPlate_name());
        plate1.setPlate_id(plate.getPlate_id());
        plateService.updatePlate(plate1);
        return "redirect:/plate";
    }

    @ResponseBody
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insertPlate(@RequestBody Plate plate){
        Plate plate1 = new Plate();
        plate1.setPlate_name(plate.getPlate_name());
        plateService.insertPlate(plate1);
        return "redirect:/plate";
    }
}
