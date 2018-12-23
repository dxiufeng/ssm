package com.itheima.dao;

import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author dxf
 * @Description  用于验证用户登录
*/
public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(property ="roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.IRole.findRolesByUserID"))
    })
    public UserInfo findByUsername(String username);



    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from users")
    public List<UserInfo> findAll(Integer page,Integer pageSize);

}
