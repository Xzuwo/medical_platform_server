package com.example.medical_platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.medical_platform.entity.Comments;
import com.example.medical_platform.entity.Users;
import com.example.medical_platform.mapper.CommentsMapper;
import com.example.medical_platform.mapper.UsersMapper;
import com.example.medical_platform.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medical_platform.util.GetNewLocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {
    
    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private UsersMapper usersMapper;


    @Override
    public List<Comments> getCommentsByPostId(Integer postId) {

        QueryWrapper<Comments> commentsQueryWrapper = new QueryWrapper<>();
        commentsQueryWrapper.eq("post_id",postId);
        List<Comments> commentsList=new ArrayList<>();

        List<Comments> comments = commentsMapper.selectList(commentsQueryWrapper);
        for (Comments comment : comments ){
            Users users = usersMapper.selectById(comment.getUserId());
            comment.setA(users.getName());
            comment.setB(users.getHeadImage());
            commentsList.add(comment);
        }


        return commentsList;
    }

    @Override
    public void addComment(Comments comments) {
        comments.setCreateTime(GetNewLocalDateTime.GetNewLocalDateTime());
        commentsMapper.insert(comments);

    }


}
