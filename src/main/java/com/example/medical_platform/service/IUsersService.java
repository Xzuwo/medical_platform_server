package com.example.medical_platform.service;

import com.example.medical_platform.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface IUsersService extends IService<Users> {
    public Users users_Login(String username,String password);
    public void setB(int userid,String b);

    public List<Users> findAll();
    public Users users_IfExit(String username);//通过username判断是否存在用户
    public Users users_IfExitFindById(Integer id);//通过id判断是否存在用户
    public void users_AddUsers(Users user);
    public void users_DeleteUsers(Integer id);
    public List<Users> FindAllUsers(Map<String,Object> map);
    public void UpdateUsers(Users user);
}
