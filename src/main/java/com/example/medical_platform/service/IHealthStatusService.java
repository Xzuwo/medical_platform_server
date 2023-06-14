package com.example.medical_platform.service;

import com.example.medical_platform.entity.HealthStatus;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface IHealthStatusService extends IService<HealthStatus> {
    public HealthStatus Get_User_HealthStatus(Integer userId);
    public void Add_User_HealthStatus(HealthStatus healthStatus);
    public void Delete_User_HealthStatus(Integer userId);
}
