package com.example.medical_platform.mapper;

import com.example.medical_platform.entity.MedicineOrders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface MedicineOrdersMapper extends BaseMapper<MedicineOrders> {
    @Select("select medicine_orders.id, users.name as username,drugs.`name` as drugsname,drugs.manufacturer as drugsManufacturer," +
            "drugs.price as drugsPrice,drugs.description as drugsDescription, quantity,`status`,create_time " +
            "from medicine_orders LEFT JOIN users on medicine_orders.user_id = users.id LEFT JOIN drugs on " +
            "medicine_orders.drugs_id = drugs.id where user_id = #{userId}")
    public List<MedicineOrders> findMedicineOrdersById(@Param("userId") Integer userId);
    @Insert("insert into medicine_orders(user_id,drugs_id,quantity,status,create_time) " +
            "values (#{userId},#{drugsId},#{quantity},'待发货',#{createTime})")
    public void generateOrder(MedicineOrders medicineOrders);
}
