package com.example.medical_platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.medical_platform.entity.UserRoles;
import com.example.medical_platform.mapper.UserRolesMapper;
import com.example.medical_platform.service.IUserRolesService;
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
public class UserRolesServiceImpl extends ServiceImpl<UserRolesMapper, UserRoles> implements IUserRolesService {

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Override
    public void AddUserRole(UserRoles userRoles) {
        userRolesMapper.insert(userRoles);
    }

    @Override
    public String findRoleName(Integer userId) {
        return userRolesMapper.findRoleName(userId);
    }

    @Override
    public void DeleteUserRole(Integer userId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        userRolesMapper.delete(queryWrapper);
    }


}
