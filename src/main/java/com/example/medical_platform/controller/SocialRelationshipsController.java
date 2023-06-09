package com.example.medical_platform.controller;

import com.example.medical_platform.service.ISocialRelationshipsService;
import com.example.medical_platform.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/social-relationships")
public class SocialRelationshipsController {
    @Autowired
    private ISocialRelationshipsService iSocialRelationshipsService;

    @RequestMapping("/add-social-relationships")
    public Map<String,Object> addSocialRelationships(int user_id1,int user_id2){
        iSocialRelationshipsService.addSocialRelationships(user_id1,user_id2);
        return new ReturnMap().returnMap(200);

    }


}
