package com.example.medical_platform.service.impl;

import com.example.medical_platform.entity.ChatMessages;
import com.example.medical_platform.mapper.ChatMessagesMapper;
import com.example.medical_platform.service.IChatMessagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzw
 * @since 2023-06-02
 */
@Service
public class ChatMessagesServiceImpl extends ServiceImpl<ChatMessagesMapper, ChatMessages> implements IChatMessagesService {

}
