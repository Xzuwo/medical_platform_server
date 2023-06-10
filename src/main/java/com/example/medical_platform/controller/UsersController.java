package com.example.medical_platform.controller;

import com.example.medical_platform.entity.Users;
import com.example.medical_platform.service.IUsersService;
import com.example.medical_platform.util.JWTUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
@RestController
public class UsersController {
    @Autowired
    private IUsersService iUsersService;

    @RequestMapping("/users/users_Login")
    public Map<String,Object> users_Login(String username,String password){
        System.out.println("进入");
        Map<String, Object> da=new HashMap<>();
        Users users = iUsersService.users_Login(username,password);
        if(users != null ) {
            Map<String,String> payload = new HashMap<>();
            payload.put("id",users.getId().toString());
            payload.put("username",users.getUsername());
            String token = JWTUtil.createToken(payload);
            da.put("code",200);
            da.put("data", users);
            da.put("token",token);
            da.put("id",users.getId());
            da.put("username",users.getUsername());
            da.put("name",users.getName());
            da.put("msg","用户查询成功");
        }else{
            da.put("code",404);
            da.put("data", null);
            da.put("token",null);
            da.put("id",null);
            da.put("username",null);
            da.put("name",null);
            da.put("msg","用户名或密码错误");
        }
        return da;
    }
    @RequestMapping("/users/findAll")
    public Map<String,Object> findAll(){
        Map<String,Object> map = new HashMap<>();
        List<Users> usersList = iUsersService.findAll();
        if(usersList != null && usersList.size() > 0){
            map.put("code",200);
            map.put("msg","查询成功");
        }else{
            map.put("code",404);
            map.put("msg","查询失败");
        }
        map.put("usersList",usersList);
        return map;
    }
}
