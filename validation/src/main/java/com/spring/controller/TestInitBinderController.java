/**
 * JBoot后台框架 v1.0.0
 * Copyright (c) 2017, Chen Peng All Rights Reserved.
 * <p>
 * 更改历史：
 * 2017-05-31 16:33    吴昭毅    创建
 */

package com.spring.controller;


import com.spring.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO 添加说明
 *
 * @author 吴昭毅
 * @version 2017-05-31 16:33
 */
public class TestInitBinderController {

    @Autowired
    //spring寻找bean id为testValidator的bean进行装填
    @Qualifier("personValidator")
    private Validator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder){

        binder.setValidator(validator);
    }


    @RequestMapping(value="add", method= RequestMethod.POST)
    public ModelAndView add(@ModelAttribute @Valid Person person, BindingResult result) {
        ModelAndView view = new ModelAndView("TestInitBinder/index");
        view.addObject("person", person);

        if (result.hasErrors()) {
            List<FieldError> errs = result.getFieldErrors();
            Map<String, String> mapErrors = new LinkedHashMap<String, String>();
            for (FieldError err : errs) {
                System.out.println("ObjectName:" + err.getObjectName() + "\tFieldName:" + err.getField()
                        + "\tFieldValue:" + err.getRejectedValue() + "\tMessage:" + err.getDefaultMessage());
                mapErrors.put(err.getField(), err.getDefaultMessage());
                view.addObject("errors", mapErrors);
            }

            return view;
        }
        return view;
    }
}
