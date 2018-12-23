package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

/**
 * 用于查询角色表中信息
 */
public interface IRoleService {
    public List<Role> findAll() throws Exception;

    public void saveRole(Role role)throws Exception;
}
