package com.example.medical_platform.controller;

import com.example.medical_platform.service.ILikesService;
import com.example.medical_platform.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@RestController
@RequestMapping("/likes")
public class LikesController {
    @Autowired
    private ILikesService iLikesService;

    @RequestMapping("/addLike")
    public HashMap<String,Object> addLike(int userid,int postsId){
//
        try {
            iLikesService.addLike( userid,postsId);
            return new ReturnMap().returnMap(322);
        }catch (Exception e){
            return new ReturnMap().returnMap(330);
        }


    }

}
