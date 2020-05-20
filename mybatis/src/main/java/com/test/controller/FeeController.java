package com.test.controller;

import com.test.entity.Fee;
import com.test.service.IFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/5/20 20:52
 */
@RestController
public class FeeController {

    @Autowired
    private IFeeService feeService;

    @RequestMapping("addFee")
    public void insertFee(@RequestBody Date fee){
        feeService.insertFee(new Fee(), fee);
    }

    @RequestMapping("queryFee")
    public void queryFee(@RequestBody Fee fee){
        List<Fee> list = feeService.queryFee(fee);
        System.out.println(Arrays.asList(list));
    }
}
