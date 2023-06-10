package com.example.medical_platform.controller;

import com.example.medical_platform.entity.Doctors;
import com.example.medical_platform.entity.Users;
import com.example.medical_platform.service.IDoctorsService;
import com.example.medical_platform.service.impl.DoctorsServiceImpl;
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
@RequestMapping("/doctors")
public class DoctorsController {
    @Autowired
    private IDoctorsService iDoctorsService;
    @RequestMapping("/findAll")
    public Map<String,Object> findAll(){
        Map<String,Object> map = new HashMap<>();
        List<Doctors> doctorsList = iDoctorsService.findAll();
        if(doctorsList != null && doctorsList.size() > 0){
            map.put("code",200);
            map.put("msg","查询成功");
        }else{
            map.put("code",404);
            map.put("msg","查询失败");
        }
        map.put("doctorsList",doctorsList);
        return map;
    }
}
