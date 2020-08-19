package com.liuxiaoyan.gameForum.controller;

import com.liuxiaoyan.gameForum.dto.PageDTO;
import com.liuxiaoyan.gameForum.dto.PostDTO;
import com.liuxiaoyan.gameForum.mapper.PlateMapper;
import com.liuxiaoyan.gameForum.mapper.PostMapper;
import com.liuxiaoyan.gameForum.mapper.UserMapper;
import com.liuxiaoyan.gameForum.model.Plate;
import com.liuxiaoyan.gameForum.model.User;
import com.liuxiaoyan.gameForum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired(required = false)
    private PostService postService;

    @Autowired(required = false)
    private PostMapper postMapper;

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private PlateMapper plateMapper;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
        PageDTO pageDTO = postService.list(page,size);
        List<PostDTO> postDTOList = postMapper.getHotList();
        List<Plate> plateList = plateMapper.findAllPlate();
        Integer plateCount = plateMapper.plateCount();
        model.addAttribute("plates",plateList);
        model.addAttribute("pageDTO", pageDTO);
        model.addAttribute("postDTOList",postDTOList);
        model.addAttribute("plateCount",plateCount);
        return "index";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(name = "page", defaultValue = "1") Integer page,
                         @RequestParam(name = "size", defaultValue = "5") Integer size,
                         @RequestParam(name = "search") String search){
        PageDTO pageDTO = postService.listSearch(search,page,size);
        model.addAttribute("pageDTO",pageDTO);
        model.addAttribute("search",search);
        return "index";
    }
    @GetMapping("/users")
    public String users(Model model){
        List<User> userList = userMapper.findAllUser();
        model.addAttribute("userList",userList);
        return "userList";
    }
    @GetMapping("/deleteUser/{user_id}")
    public String deleteUser(@PathVariable(name = "user_id") Integer user_id){
        userMapper.deleteById(user_id);
        return "redirect:/users";
    }
}
