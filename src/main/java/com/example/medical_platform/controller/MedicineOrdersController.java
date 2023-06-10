package com.example.medical_platform.controller;

import com.example.medical_platform.entity.MedicineOrders;
import com.example.medical_platform.service.IMedicineOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@RestController
@RequestMapping("/medicine-orders")
public class MedicineOrdersController {
    @Autowired
    private IMedicineOrdersService medicineOrdersService;
    @RequestMapping("/findMedicineOrdersById")
    private Map<String,Object> findMedicineOrdersById(Integer userId){
        Map<String,Object> map = new HashMap<>();
        List<MedicineOrders> medicineOrdersList = medicineOrdersService.findMedicineOrdesById(userId);
        if(medicineOrdersList != null && medicineOrdersList.size() > 0){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("medicineOrdersList",medicineOrdersList);
        }else{
            map.put("code",404);
            map.put("msg","查询失败");
            map.put("medicineOrdersList",null);
        }
        return map;
    }

    @RequestMapping("/generateOrder")
    public Map<String,Object> generateOrder(MedicineOrders medicineOrders){
        Map<String,Object> map = new HashMap<>();
        if(medicineOrders.getId() == null){
            medicineOrdersService.generateOrder(medicineOrders);
            map.put("code",200);
            map.put("msg","成功生成订单");
        }
        return map;
    }

}
