package com.example.medical_platform.service;

import com.example.medical_platform.entity.Doctors;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.medical_platform.entity.Users;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface IDoctorsService extends IService<Doctors> {
    public List<Doctors> findAll();
}
