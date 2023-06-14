package com.example.medical_platform.controller;

import com.example.medical_platform.entity.HealthStatus;
import com.example.medical_platform.service.IHealthStatusService;
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
public class HealthStatusController {
    @Autowired
    private IHealthStatusService iHealthStatusService;

    @RequestMapping("users/Get_User_HealthStatus")
    public Map<String,Object> Get_User_HealthStatus(Integer userId) {
        Map<String, Object> da=new HashMap<>();
        HealthStatus healthStatus = iHealthStatusService.Get_User_HealthStatus(userId);
        if (healthStatus != null) {
            da.put("code", 200);
            da.put("msg", "查询健康状况成功");
            da.put("healthStatus",healthStatus);
        }else{
            da.put("code", 200);
            da.put("msg", "未查询健康状况");
            da.put("healthStatus",null);
        }
        return da;
    }

    @RequestMapping("users/Add_User_HealthStatus")
    public Map<String,Object>Add_User_HealthStatus(HealthStatus healthStatus) {
        Map<String,Object> map = new HashMap<>();
        iHealthStatusService.Add_User_HealthStatus(healthStatus);
        map.put("code", 200);
        map.put("data","添加成功");
        return map;
    }

    @RequestMapping("users/Delete_User_HealthStatus")
    public Map<String,Object>Delete_User_HealthStatus(Integer userId) {
        Map<String,Object> map = new HashMap<>();
        iHealthStatusService.Delete_User_HealthStatus(userId);
        map.put("code", 200);
        map.put("data","删除成功");
        return map;
    }
}
