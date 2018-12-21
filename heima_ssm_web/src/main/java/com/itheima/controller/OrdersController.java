package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.IOrdersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
    //查询orders表中数据
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "4") Integer pageSize) throws Exception{
        List<Orders> list = ordersService.findAll(page,pageSize);
        PageInfo pi=new PageInfo(list);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pi);
        mv.setViewName("orders-list");


        return mv;
    }
}
