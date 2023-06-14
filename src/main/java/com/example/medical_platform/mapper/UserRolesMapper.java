package com.example.medical_platform.mapper;

import com.example.medical_platform.entity.UserRoles;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xzw
 * @since 2023-06-01
 */
public interface UserRolesMapper extends BaseMapper<UserRoles> {
    @Select("SELECT roles.`name`as roleName from roles LEFT JOIN user_roles on roles.id =user_roles.role_id where user_roles.user_id = #{userId}")
    public String findRoleName(@Param("userId") Integer userId);

}
