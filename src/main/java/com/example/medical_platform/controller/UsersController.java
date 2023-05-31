package com.example.medical_platform.controller;

import com.example.medical_platform.service.IUsersService;
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
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService iUsersService;

    @RequestMapping("/selectUserAll")
    public Map<String,Object> selectUserAll(){
        System.out.println("进入");
        Map<String, Object> da=new HashMap<>();
        da.put("code",200);
        da.put("data", iUsersService.SelectUsersAll());


        return da;
    }
}
