package com.example.medical_platform.mapper;

import com.example.medical_platform.entity.ChatMessages;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Setter;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Calendar;
import java.util.List;

/**
* @author 刘文阳
* @description 针对表【chat_messages】的数据库操作Mapper
* @createDate 2023-06-05 15:12:52
* @Entity com.example.medical_platform.entity.ChatMessages
*/
public interface ChatMessagesMapper extends BaseMapper<ChatMessages> {
    @Select("select * from chat_messages where (sender_id = #{senderId} and reveiver_id = #{reveiverId}) or (sender_id = #{reveiverId} and reveiver_id = #{senderId}) order by create_time asc ")
    public List<ChatMessages> findChatMessagesById(@Param("senderId") Integer senderId, @Param("reveiverId") Integer reveiverId);
}



