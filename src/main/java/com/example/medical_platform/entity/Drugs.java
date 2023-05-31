package com.example.medical_platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class Drugs implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String manufacturer;

    private BigDecimal price;

    private String description;

    private String a;

    private String b;

    private String c;
}
