/**
 * JBoot后台框架 v1.0.0
 * Copyright (c) 2017, Chen Peng All Rights Reserved.
 * <p>
 * 更改历史：
 * 2017-05-31 15:34    吴昭毅    创建
 */

package com.spring.validator;

import com.spring.pojo.Person;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * person类的validator
 *
 * @author 吴昭毅
 * @version 2017-05-31 15:34
 */
public class PersonValidator implements Validator{



    /**
     * This Validator validates *just* Person instances
     */
    public boolean supports(Class clazz) {
        return Person.class.equals(clazz);
    }

    /**
     * 校验主方法
     * @param obj
     * @param e
     */
    public void validate(Object obj, Errors e) {
        //检验参数是否为空
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Person p = (Person) obj;
        if (p.getAge() < 0) {
            e.rejectValue("age", "negativevalue");
        } else if (p.getAge() > 110) {
            e.rejectValue("age", "too.darn.old");
        }
    }
}
