package com.example.medical_platform.controller;

import com.example.medical_platform.entity.ChatMessages;
import com.example.medical_platform.service.ChatMessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatMessagesController {
    @Autowired
    private ChatMessagesService chatMessagesService;
    @RequestMapping("/findChatMessagesById")
    public Map<String,Object> findChatMessagesById(Integer senderId,Integer reveiverId){
        Map<String,Object> map = new HashMap<>();
        List<ChatMessages> chatMessagesList = chatMessagesService.findChatMessagesById(senderId,reveiverId);
        if(chatMessagesList != null && chatMessagesList.size() > 0){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("chatMessagesList",chatMessagesList);
        }else{
            map.put("code",404);
            map.put("msg","查询失败");
            map.put("chatMessagesList",null);
        }
        return map;
    }

    @RequestMapping("/sendMessage")
    public Map<String,Object> sendMessage(ChatMessages chatMessages){
        Map<String,Object> map = new HashMap<>();
        if(chatMessages.getId() == null){
            chatMessagesService.sendMessage(chatMessages);
            map.put("code",200);
            map.put("msg","发送成功");
        }
        return map;
    }
}
