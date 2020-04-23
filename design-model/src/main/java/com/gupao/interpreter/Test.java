package com.gupao.interpreter;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * @Author Administrator
 * @Date 2020/4/23 20:26
 * 解释器模式
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("result:"+new GPaoCalculator("10+30").calculate());
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("10*(10+20)*4+6");
        Object result = expression.getValue();
        System.out.println(result);
    }
}
