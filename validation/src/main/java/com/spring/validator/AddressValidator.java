/**
 * JBoot后台框架 v1.0.0
 * Copyright (c) 2017, Chen Peng All Rights Reserved.
 * <p>
 * 更改历史：
 * 2017-05-31 15:55    吴昭毅    创建
 */

package com.spring.validator;

import com.spring.pojo.Address;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * TODO 添加说明
 *
 * @author 吴昭毅
 * @version 2017-05-31 15:55
 */
public class AddressValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Address.class.isInstance(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        Address address=(Address)target;


        if(address == null){
            errors.reject("name","name is empty");
        }

    }
}
