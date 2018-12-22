package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;


    /**
     * 用于调用数据库中的user数据
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        /*  User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), getAuthority(userInfo.getRoles()));*/

        User user = new User(userInfo.getUsername(), "{noop}"+userInfo.getPassword(), userInfo.getStatus() == 1 ? true : false, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 给用户添加权限
     */

    public List<GrantedAuthority> getAuthority(List<Role> roles) {
        List<GrantedAuthority> list = new ArrayList<>();
        GrantedAuthority role_user = null;
        for (Role role : roles) {
            role_user = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
        }


        list.add(role_user);
        return list;
    }
}
