package com.example.medical_platform.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-06-01
 */
@Getter
@Setter
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;


    private Integer postId;

    private Integer parentId;

    private String content;

      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String a;

    private String b;

    private String c;
}
