package com.example.medical_platform.service.impl;

import com.example.medical_platform.entity.Posts;
import com.example.medical_platform.mapper.PostsMapper;
import com.example.medical_platform.service.IPostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements IPostsService {

}
