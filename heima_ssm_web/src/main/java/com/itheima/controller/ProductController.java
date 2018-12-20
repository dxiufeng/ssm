package com.itheima.controller;

import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import com.itheima.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("findAll")
    public ModelAndView findAll() throws Exception {
        List<Product> products = productService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }
}
