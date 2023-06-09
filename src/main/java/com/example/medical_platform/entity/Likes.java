package com.example.medical_platform.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@Getter
@Setter
public class Likes implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer postId;

      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String a;

    private String b;

    private String c;

    public Likes(Integer userId, Integer postId, LocalDateTime createTime, String a, String b, String c) {

        this.userId = userId;
        this.postId = postId;
        this.createTime = createTime;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
