package com.example.medical_platform.controller;

import com.example.medical_platform.entity.Comments;
import com.example.medical_platform.service.ICommentsService;
import com.example.medical_platform.util.ReturnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private ICommentsService iCommentsService;
    @RequestMapping("/getCommentsByPostId")
    public Map<String,Object> getCommentsByPostId(int postId){

        return new ReturnMap().returnMap(200,iCommentsService.getCommentsByPostId(postId));

    }
    @RequestMapping("/addComment")
    public Map<String,Object> addComment(Comments comments){
        iCommentsService.addComment(comments);
        return new ReturnMap().returnMap(200);
    }


}
