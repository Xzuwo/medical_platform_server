package com.example.medical_platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.medical_platform.entity.*;
import com.example.medical_platform.mapper.*;
import com.example.medical_platform.service.IPostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private PostsMapper postsMapper;

    @Autowired
    private FollowsMapper followsMapper;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private LikesMapper likesMapper;

    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Override
    public List<PostsAndUser> selectPostsAndUserPageWithFollowAndLike(Integer userId, Integer page, Integer tagId) {
        QueryWrapper<Posts> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "SELECT pt.post_id FROM post_tags pt WHERE pt.tag_id = " + (tagId+1));
        wrapper.orderByDesc("publish_time");
        wrapper.last("LIMIT " + page + ", 5");

        List<Posts> postsList = postsMapper.selectList(wrapper);

        List<PostsAndUser> result = new ArrayList<>();
        for (Posts posts : postsList) {

            PostsAndUser postsAndUser = new PostsAndUser();
            BeanUtils.copyProperties(posts, postsAndUser);
            postsAndUser.setPostsId(posts.getId());

            QueryWrapper<Follows> followsWrapper = new QueryWrapper<>();
            followsWrapper.eq("user_id", userId);
            followsWrapper.eq("follow_id", posts.getUserId());
            postsAndUser.setFollowState(followsMapper.selectCount(followsWrapper)  % 2 == 1);

            QueryWrapper<Likes> likesWrapper = new QueryWrapper<>();
            likesWrapper.eq("post_id", posts.getId())
                    .select("DISTINCT user_id");//去重
            postsAndUser.setLikeCount(Math.toIntExact(likesMapper.selectCount(likesWrapper)));


            QueryWrapper<UserRoles> userRolesQueryWrapper=new QueryWrapper<>();
            userRolesQueryWrapper.eq("user_id",posts.getUserId());
            postsAndUser.setUserRole(userRolesMapper.selectList(userRolesQueryWrapper).get(0).getRoleId());


            QueryWrapper<Comments> commentsWrapper = new QueryWrapper<>();
            commentsWrapper.eq("post_id", posts.getId());
            postsAndUser.setCommentCount(Math.toIntExact(commentsMapper.selectCount(commentsWrapper)));

            QueryWrapper<Likes> userLikeWrapper = new QueryWrapper<>();
            userLikeWrapper.eq("user_id", userId);
            userLikeWrapper.eq("post_id", posts.getId());
//            计数，计数为已点赞，偶数为未点赞或取消点赞
            postsAndUser.setLikeState(likesMapper.selectCount(userLikeWrapper) % 2 == 1);




            Users user = usersMapper.selectById(posts.getUserId());
            postsAndUser.setUser(user);

            result.add(postsAndUser);
        }

        return result;
    }

}
