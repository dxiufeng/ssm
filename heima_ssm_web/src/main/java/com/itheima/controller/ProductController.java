package com.itheima.controller;

import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    /**
     * 向数据库中存储数据
     */
   /* @RequestMapping("saveProduct")
    public void saveProduct(Product product, HttpServletRequest request, HttpServletResponse response) throws Exception{
        productService.saveProduct(product);
       response.sendRedirect(request.getContextPath()+"/product/findAll.do");
        return ;
    }*/

    @RequestMapping("saveProduct")
    public String saveProduct(Product product) throws Exception{
        productService.saveProduct(product);

        return "redirect:findAll.do";
    }
}
