package com.example.medical_platform.service;

import com.example.medical_platform.entity.SocialRelationships;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface ISocialRelationshipsService extends IService<SocialRelationships> {

    void addSocialRelationships(int user_id1, int user_id2);
}
