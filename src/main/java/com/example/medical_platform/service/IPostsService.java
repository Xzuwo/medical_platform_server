package com.example.medical_platform.service;

import com.example.medical_platform.entity.Posts;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.medical_platform.entity.PostsAndUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface IPostsService extends IService<Posts> {
    List<PostsAndUser> selectPostsAndUserPageWithFollowAndLike(Integer userId, Integer page, Integer tagId);

}
