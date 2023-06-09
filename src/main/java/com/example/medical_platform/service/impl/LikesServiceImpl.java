package com.example.medical_platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.medical_platform.entity.Likes;
import com.example.medical_platform.mapper.LikesMapper;
import com.example.medical_platform.service.ILikesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@Service
public class LikesServiceImpl extends ServiceImpl<LikesMapper, Likes> implements ILikesService {

    @Autowired
    private LikesMapper likesMapper;

    @Override
    public void addLike(int userid,int postsId) {
        Date date=new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        Likes likes=new Likes(userid,postsId,localDateTime,null,null,null);
        likesMapper.insert(likes);

    }
}
