package com.spring.demo.security;


/**
 * 当前用户线程缓存类
 */
public class CurrentUserHolder {

    private static final ThreadLocal<String> currentUser = new ThreadLocal<>();

    public static String get(){
        return currentUser.get() == null?"unknown":currentUser.get();
    }

    public static void set(String user){
        currentUser.set(user);
    }
}
