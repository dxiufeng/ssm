package com.itheima.dao;

import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITraveller {
    /**
     * orderId 通过关联表查询出旅客的信息
     */
    @Select("select * from traveller where id in(select travellerId from order_traveller where orderId=#{orderId})")
    public List<Traveller> findByOrderId(String orderId);
}
