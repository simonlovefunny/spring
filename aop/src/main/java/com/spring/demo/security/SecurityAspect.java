package com.spring.demo.security;


import com.spring.demo.service.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用于处理用于验证的切面类
 */
@Component
@Aspect
public class SecurityAspect {

    @Autowired
    AuthService authService;

    @Pointcut("@annotation(AdminOnly)")
    public void adminOnly(){

    }

    @Before("adminOnly()")
    public  void checkAccess(){
        authService.checkAccess();
    }
}
