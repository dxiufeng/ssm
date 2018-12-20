package com.itheima.controller;

import com.itheima.domain.Orders;
import com.itheima.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
    //查询orders表中数据
    @RequestMapping("findAll")
    public ModelAndView findAll(){
        List<Orders> list = ordersService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("ordersList",list);
        mv.setViewName("orders-list");
        return mv;
    }
}
