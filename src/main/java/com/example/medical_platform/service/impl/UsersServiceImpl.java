package com.example.medical_platform.service.impl;

import com.example.medical_platform.entity.Users;
import com.example.medical_platform.mapper.UsersMapper;
import com.example.medical_platform.service.IUsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> SelectUsersAll() {
        return usersMapper.selectList(null);
    }
}
