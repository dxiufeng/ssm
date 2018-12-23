package com.itheima.dao;

import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author dxf
 * @Description 用于验证用户登录
 */
public interface IUserDao {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.itheima.dao.IRole.findRolesByUserID"))
    })
    public UserInfo findByUsername(String username);


    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Select("select * from users")
    public List<UserInfo> findAll(Integer page, Integer pageSize);

    /**
     * 通过id查询出user的所有具体信息
     *
     * @param id
     * @return
     */

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "email", column = "email"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.itheima.dao.IRole.findRolesByUserID2")),
    })
    UserInfo findById(String id);


    @Insert("insert into users (email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    void saveUserInfo(UserInfo userInfo) throws Exception;
}
