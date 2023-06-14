package com.example.medical_platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.medical_platform.entity.Users;
import com.example.medical_platform.mapper.UsersMapper;
import com.example.medical_platform.service.IUsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users users_Login(String username,String password) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        return usersMapper.selectOne(queryWrapper);
    }
    @Override
    public List<Users> findAll(){
        return usersMapper.selectList(null);
    }
    @Override
    public Users users_IfExit(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        return usersMapper.selectOne(queryWrapper);
    }

    @Override
    public Users users_IfExitFindById(Integer id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);
        return usersMapper.selectOne(queryWrapper);
    }

    @Override
    public void users_AddUsers(Users user) {
        usersMapper.insert(user);
    }

    @Override
    public void users_DeleteUsers(Integer id) {
        usersMapper.deleteById(id);
    }

    @Override
    public List<Users> FindAllUsers(Map<String, Object> map) {
        QueryWrapper queryWrapper = new QueryWrapper();
        for(Map.Entry<String,Object>entry : map.entrySet()) {
            queryWrapper.like(entry.getKey(),entry.getValue());
        }
        return usersMapper.selectList(queryWrapper);
    }

    @Override
    public void UpdateUsers(Users user) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",user.getId());
        usersMapper.update(user,queryWrapper);
    }

    @Override
    public void setB(int userid, String b) {
        Users users=usersMapper.selectById(userid);
        users.setB(b);
        System.out.println("user:"+users.toString());
        usersMapper.updateById(users);
    }

}
