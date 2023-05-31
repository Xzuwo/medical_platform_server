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
 * @since 2023-06-01
 */
@Getter
@Setter
@TableName("medicine_orders")
public class MedicineOrders implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer drugsId;

    private Integer quantity;

    private String status;

      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    private String a;

    private String b;

    private String c;
}
