package com.example.medical_platform.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//这是一个返回类
//有三个重载方法，分别为类型（code）、数据(datObject),其他（暂时为令牌token）

public class returnMap {
    HashMap<String,Object> da=new HashMap<>();

    //重载
    public HashMap<String , Object> returnMap(Integer code,Object dataObjet,String token){//传：该用户信息、code、密令
        da.put("code", 200);
        da.put("message", "密码正确");
        da.put("dataobject", dataObjet);
        da.put("token", token);
        return da;
    }

    public  HashMap<String, Object> returnMap(Integer code, Object dataobject) {
        if( code == 200 ){
            da.put("code",code);
            da.put("message","操作成功");
        }else if( code == 500){
            da.put("code",code);
            da.put("message","操作失败");
        }else if( code == 404){
            da.put("code",code);
            da.put("message","参数校验失败");
        }else if( code == 401){
            da.put("code",code);
            da.put("message","暂未登陆或token已经过期");
        }else if( code == 403){
            da.put("code",code);
            da.put("message","没有相关权限");
        }else if( code == 300){
            da.put("code",code);
            da.put("message","用户名或密码错误");
        }
        da.put("dataobject",dataobject);
        return da;
    }
    public HashMap<String, Object> returnMap(Integer code) {
        if (code == 200) {
            da.put("code", code);
            da.put("message", "操作成功");
        } else if (code == 500) {
            da.put("code", code);
            da.put("message", "操作失败");
        } else if (code == 404) {
            da.put("code", code);
            da.put("message", "参数校验失败");
        } else if (code == 401) {
            da.put("code", code);
            da.put("message", "暂未登陆或token已经过期");
        } else if (code == 403) {
            da.put("code", code);
            da.put("message", "没有相关权限");
        } else if (code == 300) {
            da.put("code", code);
            da.put("message", "用户名或密码错误");
        } else if (code == 204) {
            da.put("code", code);
            da.put("message", "收藏取消成功！");
        } else if (code == 206) {
            da.put("code", code);
            da.put("message", "收藏成功！");
        }
        return da;
    }
}
