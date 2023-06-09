package com.example.medical_platform.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author xzw
 * @since 2023-06-02
 */
@Getter
@Setter
@TableName("chat_messages")
public class ChatMessages implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发送
     */
    private Integer senderId;

    /**
     * 接收
     */
    private Integer reveiverId;

    private String message;

      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String a;

    private String b;

    private String c;
}
