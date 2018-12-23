package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRole {
    //正常登陆操作
    @Select("select * from role where id in(select roleID from users_role where userId=#{userId})")
    public List<Role> findRolesByUserID(String userId);



    //查询操作
    @Select("select * from role where id in(select roleID from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRolesByUserID2(String userId);



    //查询所有
    @Select("select * from role")
    public List<Role> findAll();


    //保存role操作
    @Select("insert into role (roleName,roleDesc) values (#{roleName},#{roleDesc})")
    public void saveRole(Role role);
}
