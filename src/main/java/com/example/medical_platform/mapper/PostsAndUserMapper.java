package com.example.medical_platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.medical_platform.entity.Posts;
import com.example.medical_platform.entity.PostsAndUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface PostsAndUserMapper extends BaseMapper<PostsAndUser> {
//    List<PostsAndUser> selectPostsAndUserPageWithFollowAndLike(@Param("page") Integer page,
//                                                               @Param("userId") Integer userId,
//                                                               @Param("tagId") Integer tagId);
//    List<Posts> testPosts();

    List<PostsAndUser> selectMapsPage(Map<String, Object> params);
//    @Select("select * from posts")
//    List<Posts> testPosts();
}
