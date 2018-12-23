package com.itheima.service.impl;

import com.itheima.dao.IPermissionDao;
import com.itheima.domain.Permission;
import com.itheima.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;

    @Override//查询所有权限
    public List<Permission> findAll() throws Exception {
        List<Permission> permissions = permissionDao.findAll();
        return permissions;
    }

    @Override//添加权限
    public void savePermission(Permission permission) throws Exception {
        permissionDao.savePermission(permission);
    }
}
