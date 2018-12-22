package com.itheima.service;

import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author dxf
 * @Description  让接口继承userDetailService接口,使IUserService的实现类能重写UserDetailsService中的方法,用于实现功能
*/
public interface IUserService extends UserDetailsService{

}
