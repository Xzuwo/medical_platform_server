package com.example.medical_platform.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.medical_platform.entity.PostsAndUser;
import com.example.medical_platform.service.ITagsService;
import com.example.medical_platform.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@RestController
@RequestMapping("/tags")
public class TagsController {
    @Autowired
    private ITagsService iTagsService;

    @RequestMapping("/GetTagsAll")
    public HashMap<String, Object> GetTagsAll(){


       return new ReturnMap().returnMap(200,iTagsService.GetTagsAll());
    }


    
}   
