package com.gupaoedu.demo.mvc.service.impl;

import com.gupaoedu.demo.mvc.service.IDemoService;
import com.gupaoedu.mvcframework.annotation.GPService;

/**
 * @Author Administrator
 * @Date 2020/4/27 20:36
 */
@GPService
public class DemoServiceImpl implements IDemoService {
    @Override
    public String query(String name) {
        String str = "this is from service,"+name;
        return str;
    }
}
