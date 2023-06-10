package com.example.medical_platform.service;

import com.example.medical_platform.entity.ChatMessages;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 刘文阳
* @description 针对表【chat_messages】的数据库操作Service
* @createDate 2023-06-05 15:12:52
*/
public interface ChatMessagesService extends IService<ChatMessages> {
    public List<ChatMessages> findChatMessagesById(Integer senderId,Integer reveiverId);
    public void sendMessage(ChatMessages chatMessages);
}
