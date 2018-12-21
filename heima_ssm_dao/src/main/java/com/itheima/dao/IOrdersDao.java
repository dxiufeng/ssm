package com.itheima.dao;

import com.itheima.domain.Member;
import com.itheima.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDest", column = "orderDest"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDes", column = "orderDes"),
            @Result(property = "product",column = "productId",javaType = Process.class,one = @One(select = "com.itheima.dao.IProductDao.findById"))
    })
    public List<Orders> findAll(Integer pageNum,Integer pageSize) throws Exception;


    //查询一个Orders对象
    @Select("select * from orders where id=#{orderId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "orderDest", column = "orderDest"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDes", column = "orderDes"),
            @Result(property = "product",column = "productId",javaType = Process.class,one = @One(select = "com.itheima.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.itheima.dao.IMemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.ITraveller.findByOrderId"))
    })
    public Orders findById(String orderId);
}
