package com.itheima.dao;

import com.itheima.domain.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> findAll () throws Exception;
}
