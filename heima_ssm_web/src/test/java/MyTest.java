import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import com.itheima.service.impl.ProductServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    public static void main(String[] args) throws Exception{
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        IProductService productService = (IProductService) ac.getBean(ProductServiceImpl.class);
        List<Product> products = productService.findAll();
        System.out.println(products);


    }

}