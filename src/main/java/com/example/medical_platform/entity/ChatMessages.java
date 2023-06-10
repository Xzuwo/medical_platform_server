package com.example.medical_platform.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 
 * @TableName chat_messages
 */
@TableName(value ="chat_messages")
public class ChatMessages implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 发送
     */
    private Integer senderId;

    /**
     * 接收
     */
    private Integer reveiverId;

    /**
     * 
     */
    private String message;

    /**
     * 
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 
     */
    private String a;

    /**
     * 
     */
    private String b;

    /**
     * 
     */
    private String c;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 发送
     */
    public Integer getSenderId() {
        return senderId;
    }

    /**
     * 发送
     */
    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    /**
     * 接收
     */
    public Integer getReveiverId() {
        return reveiverId;
    }

    /**
     * 接收
     */
    public void setReveiverId(Integer reveiverId) {
        this.reveiverId = reveiverId;
    }

    /**
     * 
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     *
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     */
    public String getA() {
        return a;
    }

    /**
     * 
     */
    public void setA(String a) {
        this.a = a;
    }

    /**
     * 
     */
    public String getB() {
        return b;
    }

    /**
     * 
     */
    public void setB(String b) {
        this.b = b;
    }

    /**
     * 
     */
    public String getC() {
        return c;
    }

    /**
     * 
     */
    public void setC(String c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ChatMessages other = (ChatMessages) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSenderId() == null ? other.getSenderId() == null : this.getSenderId().equals(other.getSenderId()))
            && (this.getReveiverId() == null ? other.getReveiverId() == null : this.getReveiverId().equals(other.getReveiverId()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getA() == null ? other.getA() == null : this.getA().equals(other.getA()))
            && (this.getB() == null ? other.getB() == null : this.getB().equals(other.getB()))
            && (this.getC() == null ? other.getC() == null : this.getC().equals(other.getC()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSenderId() == null) ? 0 : getSenderId().hashCode());
        result = prime * result + ((getReveiverId() == null) ? 0 : getReveiverId().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getA() == null) ? 0 : getA().hashCode());
        result = prime * result + ((getB() == null) ? 0 : getB().hashCode());
        result = prime * result + ((getC() == null) ? 0 : getC().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", senderId=").append(senderId);
        sb.append(", reveiverId=").append(reveiverId);
        sb.append(", message=").append(message);
        sb.append(", createTime=").append(createTime);
        sb.append(", a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}