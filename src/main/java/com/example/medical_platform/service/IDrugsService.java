package com.example.medical_platform.service;

import com.example.medical_platform.entity.Drugs;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface IDrugsService extends IService<Drugs> {
    public List<Drugs> findAllDrugs();
    public List<Drugs> findAllByMapper(String drugsname);
}
