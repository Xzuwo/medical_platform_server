package com.example.medical_platform.service;

import com.example.medical_platform.entity.PostsAndUser;
import com.example.medical_platform.entity.Tags;
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
public interface ITagsService extends IService<Tags> {

    public List<Tags> GetTagsAll();


}
