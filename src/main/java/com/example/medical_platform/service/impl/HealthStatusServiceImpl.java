package com.example.medical_platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.medical_platform.entity.HealthStatus;
import com.example.medical_platform.mapper.HealthStatusMapper;
import com.example.medical_platform.service.IHealthStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@Service
public class HealthStatusServiceImpl extends ServiceImpl<HealthStatusMapper, HealthStatus> implements IHealthStatusService {

    @Autowired
    private HealthStatusMapper healthStatusMapper;

    @Override
    public HealthStatus Get_User_HealthStatus(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        return healthStatusMapper.selectOne(queryWrapper);
    }

    @Override
    public void Add_User_HealthStatus(HealthStatus healthStatus) {
        healthStatusMapper.insert(healthStatus);
    }

    @Override
    public void Delete_User_HealthStatus(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        healthStatusMapper.delete(queryWrapper);
    }

}
