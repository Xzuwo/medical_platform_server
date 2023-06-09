package com.example.medical_platform.service.impl;

import com.example.medical_platform.entity.SocialRelationships;
import com.example.medical_platform.mapper.SocialRelationshipsMapper;
import com.example.medical_platform.service.ISocialRelationshipsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SocialRelationshipsServiceImpl extends ServiceImpl<SocialRelationshipsMapper, SocialRelationships> implements ISocialRelationshipsService {

    @Autowired
    private SocialRelationshipsMapper socialRelationshipsMapper;

    @Override
    public void addSocialRelationships(int user_id1, int user_id2) {
        SocialRelationships socialRelationships=new SocialRelationships();
        socialRelationships.setUserId1(user_id1);
        socialRelationships.setUserId2(user_id2);
        socialRelationshipsMapper.insert(socialRelationships);
    }
}
