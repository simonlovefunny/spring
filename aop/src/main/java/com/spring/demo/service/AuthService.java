package com.spring.demo.service;



import com.spring.demo.security.CurrentUserHolder;
import org.springframework.stereotype.Component;


/**
 * 校验当前用户是否是admin
 */
@Component
public class AuthService {

    public void checkAccess(){
        String user= CurrentUserHolder.get();
        if(!"admin".equals(user)){
            throw new RuntimeException("operation not allow");
        }
    }
}
