package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author dxf
 * @Description  用于对Product表中数据进行操作
*/
public interface IProductDao {

    @Select("select * from product")
    public List<Product> findAll () throws Exception;

    @Insert("insert into product (productNum,productName,cityName,productPrice,productDesc,productStatus,departureTime) values (#{productNum},#{productName},#{cityName},#{productPrice},#{productDesc},#{productStatus},#{departureTime})")
    void saveProduct(Product product) throws Exception;


    /**
     * 通过id来查找一个product
     */
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;
}
