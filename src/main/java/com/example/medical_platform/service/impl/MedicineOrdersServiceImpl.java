package com.example.medical_platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.medical_platform.entity.MedicineOrders;
import com.example.medical_platform.mapper.MedicineOrdersMapper;
import com.example.medical_platform.service.IMedicineOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@Service
public class MedicineOrdersServiceImpl extends ServiceImpl<MedicineOrdersMapper, MedicineOrders> implements IMedicineOrdersService {
    @Autowired
    private MedicineOrdersMapper medicineOrdersMapper;
    @Override
    public List<MedicineOrders> findMedicineOrdesById(Integer userId) {
        return medicineOrdersMapper.findMedicineOrdersById(userId);
    }

    @Override
    public void generateOrder(MedicineOrders medicineOrders) {
        Date date=new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        medicineOrders.setCreateTime(localDateTime);
        medicineOrdersMapper.generateOrder(medicineOrders);
    }


}
