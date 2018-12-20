package com.itheima.service.impl;

import com.itheima.dao.IProductDao;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author dxf
 * @Description  对product表数据进行操作
*/
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception{

        return productDao.findAll();
    }

    /**
     * 保存数据
     * @param product
     */
    @Override
    public void saveProduct(Product product) throws Exception{
        System.out.println(product);
        productDao.saveProduct(product);

    }
}
