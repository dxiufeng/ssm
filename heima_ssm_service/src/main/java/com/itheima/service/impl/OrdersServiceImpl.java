package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.IOrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.IOrdersService;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao ordersDao;
    @Override
    public List<Orders> findAll(Integer page,Integer pageSize) throws Exception{

        PageHelper.startPage(page, pageSize);
        List<Orders> list = ordersDao.findAll(page,pageSize);
        return list;
    }

    @Override
    public Orders findById(String orderId) {
        return ordersDao.findById(orderId);
    }
}
