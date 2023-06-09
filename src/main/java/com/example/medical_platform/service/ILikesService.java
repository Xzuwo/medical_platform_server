package com.example.medical_platform.service;

import com.example.medical_platform.entity.Likes;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface ILikesService extends IService<Likes> {

    void addLike(int userid,int postsId);
}
