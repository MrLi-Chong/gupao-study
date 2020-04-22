package com.gupao.merment;

import java.util.Stack;

/**
 * @Author Administrator
 * @Date 2020/4/22 14:19
 */
public class DraftBox {
    private final Stack<ArticleMerment> stack = new Stack<>();
    public ArticleMerment getMerment(){
        return stack.pop();
    }

    public void addMerment(ArticleMerment merment){
        stack.push(merment);
    }
}
