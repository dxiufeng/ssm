package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRole {
    @Select("select * from role where id in(select roleID from users_role where userId=#{userId})")
    public List<Role> findRolesByUserID(String userId);
}
