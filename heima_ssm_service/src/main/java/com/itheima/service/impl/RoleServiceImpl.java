package com.itheima.service.impl;

import com.itheima.dao.IRole;
import com.itheima.domain.Role;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRole roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        List<Role> roles = roleDao.findAll();


        return roles;
    }

    @Override
    public void saveRole(Role role) throws Exception {
        roleDao.saveRole(role);
    }
}
