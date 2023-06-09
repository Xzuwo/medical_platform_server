package com.example.medical_platform.service.impl;

import com.example.medical_platform.entity.PostsAndUser;
import com.example.medical_platform.entity.Tags;
import com.example.medical_platform.mapper.TagsMapper;
import com.example.medical_platform.service.ITagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements ITagsService {



    @Autowired
    private TagsMapper tagsMapper;

    @Override
    public List<Tags> GetTagsAll() {
        return tagsMapper.selectList(null);
    }


}
