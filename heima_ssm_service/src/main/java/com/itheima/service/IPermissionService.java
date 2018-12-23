package com.itheima.service;

import com.itheima.domain.Permission;


import java.util.List;

/**
 * @Author dxf
 * @Description  对permission表进行操作的service接口
*/
public interface IPermissionService {
    public List<Permission> findAll()throws Exception;//查询所有
    public void savePermission(Permission permission) throws Exception;//添加权限
}
