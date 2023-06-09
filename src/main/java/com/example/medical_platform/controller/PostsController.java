package com.example.medical_platform.controller;

import com.example.medical_platform.entity.PostsAndUser;
import com.example.medical_platform.service.IPostsAndUserService;
import com.example.medical_platform.service.IPostsService;
import com.example.medical_platform.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private IPostsService iPostsService;

    @Autowired
    private IPostsAndUserService iPostsAndUserService;


    @RequestMapping("/getPostByUser")
    public HashMap<String, Object> getPostByUser(String userid, Integer page, Integer tagId){
        Integer userid2;
        if(userid==null || userid.equals("")){
            userid2=0;
        }else{
            userid2=Integer.parseInt(userid);
        }

        List<PostsAndUser> postsAndUser=iPostsService.selectPostsAndUserPageWithFollowAndLike(userid2,page,tagId);

        return new ReturnMap().returnMap(200,postsAndUser);

    }

}
