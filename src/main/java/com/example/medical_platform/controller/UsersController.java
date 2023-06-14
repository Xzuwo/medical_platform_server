package com.example.medical_platform.controller;

import com.example.medical_platform.entity.Users;
import com.example.medical_platform.service.IUsersService;
import com.example.medical_platform.util.JWTUtil;
import com.example.medical_platform.util.ReturnMap;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/users/setB")
    public Map<String,Object> setB(int userid,String b){
        iUsersService.setB(userid,b);
        return new ReturnMap().returnMap(200);
    }

    @RequestMapping("/user_AddUsers")
    public Map<String,Object> users_AddUsers( Users users) {
        Map<String, Object> da=new HashMap<>();
        Users user = new Users();
        user = iUsersService.users_IfExit(users.getName());
        if(user == null) {
            iUsersService.users_AddUsers(users);
            da.put("code",200);
            da.put("msg","添加用户成功");
        }else{
            da.put("code",404);
            da.put("msg","该用户已经存在");
        }
        return da;
    }

    @RequestMapping("users/users_DeleteUsers")
    public Map<String,Object> users_DeleteUsers(Integer id) {
        Map<String, Object> da=new HashMap<>();
        Users user = new Users();
        user = iUsersService.users_IfExitFindById(id);
        if(user != null) {
            iUsersService.users_DeleteUsers(id);
            da.put("code",200);
            da.put("msg","删除用户成功");
        }else{
            da.put("code",404);
            da.put("msg","该用户不存在");
        }
        return da;
    }

    @RequestMapping("users/FindAllUsers")
    public Map<String,Object> FindAllUsers(@RequestParam Map<String,Object> map) {
        Map<String, Object> da=new HashMap<>();
        List<Users> list = iUsersService.FindAllUsers(map);
        if(list != null && list.size() >0) {
            da.put("code", 200);
            da.put("usersList",list);
            da.put("msg","查询用户信息成功");
        }else{
            da.put("code", 404);
            da.put("usersList",null);
            da.put("msg","未查询到用户信息");
        }
        return da;
    }

    @RequestMapping("user_IfExit")
    public Map<String,Object> users_IfExit(String username) {
        Map<String, Object> da=new HashMap<>();
        Users users = new Users();
        users = iUsersService.users_IfExit(username);
        if(users != null) {
            da.put("user",users);
            da.put("code",200);
        }else{
            da.put("user",null);
            da.put("code",404);
        }
        return da;
    }

    @RequestMapping("users/UpdateUsers")
    public Map<String,Object> UpdateUsers(Users user) {
        Map<String, Object> da=new HashMap<>();
        Users users = iUsersService.users_IfExitFindById(user.getId());
        if(users != null) {
            iUsersService.UpdateUsers(user);
            da.put("code",200);
            da.put("msg","当前用户密码为" + user.getPassword());
        }else{
            da.put("code",404);
            da.put("msg","该用户不存在");
        }
        return  da;
    }

}
