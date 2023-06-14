package com.example.medical_platform.controller;

import com.example.medical_platform.entity.Drugs;
import com.example.medical_platform.entity.Users;
import com.example.medical_platform.service.IDrugsService;
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
@RequestMapping("/drugs")
public class DrugsController {
    @Autowired
    private IDrugsService drugsService;
    @RequestMapping("/findAllDrugs")
    public Map<String,Object> findAllDrugs(){
        Map<String,Object> map = new HashMap<>();
        List<Drugs> drugsList = drugsService.findAllDrugs();
        if(drugsList != null && drugsList.size() > 0){
            map.put("code",200);
            map.put("msg","查询成功");
        }else{
            map.put("code",404);
            map.put("msg","查询失败");
        }
        map.put("drugsList",drugsList);
        return map;
    }
    @RequestMapping("/findAllByMapper")
    public Map<String,Object> findAllByMapper(String drugsname){
        Map<String,Object> map = new HashMap<>();
        List<Drugs> drugsList = drugsService.findAllByMapper(drugsname);
        if(drugsList != null && drugsList.size() > 0){
            map.put("code",200);
            map.put("msg","查询成功");
            map.put("drugsList",drugsList);
        }else{
            map.put("code",404);
            map.put("msg","没有该药品");
            map.put("drugsList",null);
        }
        return map;
    }

    @RequestMapping("users/FindAllDrugs")
    public Map<String,Object> FindAllDrugs(@RequestParam Map<String,Object> map) {
        Map<String,Object> da = new HashMap<>();
        List<Drugs> list = drugsService.FindAllDrugs(map);
        da.put("code",200);
        da.put("msg","查询药品成功");
        da.put("DrugList",list);
        return da;
    }

    @RequestMapping("users/UpdateDrugs")
    public Map<String,Object> UpdateDrugs(Drugs drugs) {
        Map<String,Object> da = new HashMap<>();
        drugsService.UpdateDrugs(drugs);
        da.put("code",200);
        da.put("msg","修改药品成功");
        return da;
    }

    @RequestMapping("users/AddDrugs")
    public Map<String,Object> AddDrugs(Drugs drugs) {
        Map<String,Object> da = new HashMap<>();
        drugsService.AddDrugs(drugs);
        da.put("code",200);
        da.put("msg","添加药品成功");
        return da;
    }

    @RequestMapping("users/DeleteDrugs")
    public Map<String,Object> DeleteDrugs(String DrugsName){
        Map<String,Object> da = new HashMap<>();
        drugsService.DeleteDrugs(DrugsName);
        da.put("code",200);
        da.put("msg","删除药品成功");
        return da;
    }

}
