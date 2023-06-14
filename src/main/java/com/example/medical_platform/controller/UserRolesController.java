package com.example.medical_platform.controller;

import com.example.medical_platform.entity.UserRoles;
import com.example.medical_platform.service.IUserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
@RequestMapping("/user-roles")
public class UserRolesController {
    @Autowired
    private IUserRolesService iUserRolesService;

    @RequestMapping("users/AddUserRole")
    public Map<String,Object> AddUserRole(UserRoles userRoles) {
        Map<String, Object> da=new HashMap<>();
        iUserRolesService.AddUserRole(userRoles);
        da.put("code",200);
        da.put("msg","添加角色成功");
        return da;
    }

    @RequestMapping("users/findRoleName")
    public Map<String,Object> findRoleName (Integer userId) {
        Map<String, Object> da=new HashMap<>();
        String roleName = iUserRolesService.findRoleName(userId);
        da.put("code",200);
        da.put("roleName",roleName);
        da.put("msg","查询角色成功");
        return da;
    }

    @RequestMapping("users/DeleteUserRole")
    public Map<String,Object> DeleteUserRole(Integer userId) {
        Map<String, Object> da=new HashMap<>();
        iUserRolesService.DeleteUserRole(userId);
        da.put("code",200);
        da.put("msg","删除角色成功");
        return da;
    }

}
