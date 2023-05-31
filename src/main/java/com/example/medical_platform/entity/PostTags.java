package com.example.medical_platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("post_tags")
public class PostTags implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer postId;

    private Integer tagId;

    private String a;

    private String b;

    private String c;
}
