package com.example.medical_platform.service;

import com.example.medical_platform.entity.Comments;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface ICommentsService extends IService<Comments> {
    List<Comments> getCommentsByPostId(Integer postId);
    void addComment(Comments comments);
}
