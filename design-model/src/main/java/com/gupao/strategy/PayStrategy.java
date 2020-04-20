package com.gupao.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2020/4/19 20:08
 */
public class PayStrategy {
    private static Map<String,Payment> map = new HashMap<>();
    private static final String ALI_PAY = "ALIPAY";
    private static final String JD_PAY = "JDPAY";
    private static final String WECHAT_PAY = "WECHATPAY";
    private static final String DEFAULT_PAY = ALI_PAY;
    static {
        map.put(ALI_PAY,new AliPay());
        map.put(JD_PAY,new JdPay());
        map.put(WECHAT_PAY,new WechatPay());
    }

    public static Payment pay(String payKey){
        if(!map.containsKey(payKey)){
            return map.get(DEFAULT_PAY);
        }
        return map.get(payKey);
    }
}
