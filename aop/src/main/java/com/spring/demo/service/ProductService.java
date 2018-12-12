package com.spring.demo.service;

import com.spring.demo.domain.Product;
import com.spring.demo.security.AdminOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 业务逻辑为只有admin用户才能进行delete和update操作
 */
@Service
public class ProductService {


    @Autowired
    private AuthService authService;

    @AdminOnly
    public void updateProduct(Product product){
        //传统OOP方式实现权限校验
        //authService.checkAccess();
        System.out.println("update product");
    }

    @AdminOnly
    public void deleteProduct(Long id){
        //传统OOP方式实现权限校验
        //authService.checkAccess();
        System.out.println("delete product");
    }

}
