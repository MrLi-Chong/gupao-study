package com.gupaoedu.demo.mvc.action;

import com.gupaoedu.demo.mvc.service.IDemoService;
import com.gupaoedu.framework.annotation.GPAutowired;
import com.gupaoedu.framework.annotation.GPController;
import com.gupaoedu.framework.annotation.GPRequestMapping;
import com.gupaoedu.framework.annotation.GPRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Administrator
 * @Date 2020/4/26 20:25
 */
@GPController
@GPRequestMapping("/demo")
public class DemoAction {

    @GPAutowired
    private IDemoService demoService;

    @GPRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      @GPRequestParam(value = "name")String name){
        String result = "";
        try {
            result = demoService.query(name);
            response.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
