package com.example.medical_platform.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medical_platform.entity.Posts;
import com.example.medical_platform.entity.PostsAndUser;
import com.example.medical_platform.entity.Roles;
import com.example.medical_platform.mapper.PostsAndUserMapper;
import com.example.medical_platform.mapper.PostsMapper;
import com.example.medical_platform.mapper.RolesMapper;
import com.example.medical_platform.service.IPostsAndUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostsAndUserImpl extends ServiceImpl<PostsAndUserMapper, PostsAndUser> implements IPostsAndUserService {
    @Autowired
    private PostsAndUserMapper postsAndUserMapper;

//    @Autowired
//    private PostsMapper postsMapper;
    @Override
    public List<PostsAndUser> getPostByUser(Integer userId, Integer pageNum, Integer tagId) {

//        postsAndUserMapper.testPosts();
        Page<Map<String, Object>> page = new Page<>(pageNum*10, 10);
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("tagId", tagId);
        params.put("page", (pageNum - 1) * 10);
        postsAndUserMapper.selectMapsPage(params);


        return null;
//        return postsAndUserMapper.selectPostsAndUserPageWithFollowAndLike(page,userId,tagId);
    }


}
