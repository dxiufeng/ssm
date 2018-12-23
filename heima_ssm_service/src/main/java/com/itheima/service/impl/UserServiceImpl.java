package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 给用户添加权限
     */

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add( new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        return list;
    }


    /**
     * 查询所有用户信息(只有用户不包含别的)
     * @return
     */
    @Override
    public List<UserInfo> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<UserInfo> users = userDao.findAll(page,pageSize);
        return users;
    }

    /**
     * 查询userinfo的所有信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findById(String id) throws Exception{
        UserInfo userInfo = userDao.findById(id);
        return userInfo;
    }


    /**
     * 用户添加
     */

    @Override
    public void saveUserInfo(UserInfo userInfo) throws Exception {
        //对存入的密码进行加密操作
        String encodePassword = new BCryptPasswordEncoder().encode(userInfo.getPassword());
        userInfo.setPassword(encodePassword);
        userDao.saveUserInfo(userInfo);
    }
}
