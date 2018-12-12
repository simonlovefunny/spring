package com.spring;



import com.spring.demo.security.CurrentUserHolder;
import com.spring.demo.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring AOP学习代码测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-context.xml")
public class AopGuideApplicationTests {


    @Autowired
    ProductService productService;

    @Test(expected = Exception.class)
    public void checkAccessTest(){
        CurrentUserHolder.set("user");
        productService.deleteProduct(1l);
    }

    @Test
    public void checkAccessTestError(){
        CurrentUserHolder.set("user");
        productService.deleteProduct(1l);
    }
}
