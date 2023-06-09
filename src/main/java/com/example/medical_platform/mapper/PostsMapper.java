package com.example.medical_platform.mapper;

import com.example.medical_platform.entity.Posts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.medical_platform.entity.PostsAndUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
@Mapper
public interface PostsMapper extends BaseMapper<Posts> {
}
