package com.example.medical_platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.medical_platform.entity.Drugs;
import com.example.medical_platform.mapper.DrugsMapper;
import com.example.medical_platform.service.IDrugsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@Service
public class DrugsServiceImpl extends ServiceImpl<DrugsMapper, Drugs> implements IDrugsService {
    @Autowired
    private DrugsMapper drugsMapper;
    @Override
    public List<Drugs> findAllDrugs() {
        return drugsMapper.selectList(null);
    }

    @Override
    public List<Drugs> findAllByMapper(String drugsname) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name",drugsname);
        return drugsMapper.selectList(wrapper);
    }

    @Override
    public List<Drugs> FindAllDrugs(Map<String, Object> map) {
        QueryWrapper queryWrapper = new QueryWrapper();
        for(Map.Entry<String,Object>entry : map.entrySet()) {
            queryWrapper.like(entry.getKey(),entry.getValue());
        }
        return drugsMapper.selectList(queryWrapper);
    }

    @Override
    public void UpdateDrugs(Drugs drugs) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",drugs.getId());
        drugsMapper.update(drugs,queryWrapper);
    }

    @Override
    public void AddDrugs(Drugs drugs) {
        drugsMapper.insert(drugs);
    }

    @Override
    public void DeleteDrugs(String DrugsName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",DrugsName);
        drugsMapper.delete(queryWrapper);
    }

}
