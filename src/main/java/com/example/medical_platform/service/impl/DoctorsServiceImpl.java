package com.example.medical_platform.service.impl;

import com.example.medical_platform.entity.Doctors;
import com.example.medical_platform.mapper.DoctorsMapper;
import com.example.medical_platform.service.IDoctorsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class DoctorsServiceImpl extends ServiceImpl<DoctorsMapper, Doctors> implements IDoctorsService {

    @Autowired
    private DoctorsMapper doctorsMapper;
    @Override
    public List<Doctors> findAll() {
        return doctorsMapper.selectList(null);
    }
}
