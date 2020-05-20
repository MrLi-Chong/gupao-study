package com.test.controller;

import com.test.entity.Fee;
import com.test.entity.User;
import com.test.service.IFeeService;
import com.test.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/5/18 22:38
 */
@RunWith(SpringRunner.class) //用于配置spring中测试的环境
@WebAppConfiguration
@SpringBootTest
public class UserTest {
    @Resource
    private IUserService service;

    @Autowired
    private IFeeService feeService;

    @Test
    public void insertUser(){
        User user = new User();
        user.setUserid("2");
        Assert.assertEquals("",1,service.insertUser(user));
    }

    @Test
    public void querUser(){
        User user = new User();
        user.setUserid("1");
        List<User> list = service.queryUser(user);
        System.out.println(Arrays.asList(list));
    }

    @Test
    public void insertFee(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse("20200420", pos);
        Fee fee = new Fee();
        fee.setId(1);
        fee.setFeeAmt(245d);
        fee.setFeeDate(strtodate);
        feeService.insertFee(fee,strtodate);
    }

    @Test
    public void queryFee(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse("20200520", pos);
        Fee fee = new Fee();
        fee.setFeeDate(strtodate);
        List<Fee> list = feeService.queryFee(fee);
        System.out.println(Arrays.asList(list));
    }
}
