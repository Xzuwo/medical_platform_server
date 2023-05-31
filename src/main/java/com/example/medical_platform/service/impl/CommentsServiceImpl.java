package com.example.medical_platform.service.impl;

import com.example.medical_platform.entity.Comments;
import com.example.medical_platform.mapper.CommentsMapper;
import com.example.medical_platform.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
