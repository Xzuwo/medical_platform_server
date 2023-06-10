package com.example.medical_platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.medical_platform.entity.ChatMessages;
import com.example.medical_platform.service.ChatMessagesService;
import com.example.medical_platform.mapper.ChatMessagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
* @author 刘文阳
* @description 针对表【chat_messages】的数据库操作Service实现
* @createDate 2023-06-05 15:12:52
*/
@Service
public class ChatMessagesServiceImpl extends ServiceImpl<ChatMessagesMapper, ChatMessages>
    implements ChatMessagesService{
    @Autowired
    private ChatMessagesMapper chatMessagesMapper;
    @Override
    public List<ChatMessages> findChatMessagesById(Integer senderId,Integer reveiverId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        //queryWrapper.eq("sender_id",senderId);
        //queryWrapper.eq("reveiver_id",reveiverId);
        return chatMessagesMapper.findChatMessagesById(senderId,reveiverId);
    }

    @Override
    public void sendMessage(ChatMessages chatMessages) {
        Date date=new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        chatMessages.setCreateTime(localDateTime);
        chatMessagesMapper.insert(chatMessages);
    }
}




