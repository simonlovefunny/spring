/**
 * JBoot后台框架 v1.0.0
 * Copyright (c) 2017, Chen Peng All Rights Reserved.
 * <p>
 * 更改历史：
 * 2017-05-31 16:21    吴昭毅    创建
 */

package com.spring.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * spring-context配置了JSR-303 Validator定义后，可以使用javax.validation.constraints注解
 *
 * @author 吴昭毅
 * @version 2017-05-31 16:21
 */
public class PersonForm {


    @NotNull
    @Size(max = 64)
    protected String name;
    @Min(0)
    private int age;
}
