package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface IPermissionDao {

    /**
     * 通过id查询
     * @param roleId
     * @return
     */
    @Select("select * from permission where id in (select PermissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findPermissionByRoleId(String roleId);


    /**
     * 查询所有权限
     */
    @Select("select * from Permission")
    public List<Permission> findAll();


    /**
     * 添加权限
     */
    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    public void savePermission(Permission permission);
}
