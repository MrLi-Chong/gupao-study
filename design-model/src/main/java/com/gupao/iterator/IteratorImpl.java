package com.gupao.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/4/20 20:11
 */
public class IteratorImpl<E> implements Iterator<E> {
    private List<E> list;
    private int cursor;
    private E element;

    public IteratorImpl(List<E> list) {
        this.list = list;
    }

    @Override
    public E next() {
        System.out.print("当前位置："+cursor+":");
        element = list.get(cursor);
        cursor++;
        return element;
    }

    @Override
    public boolean hasNext() {
        if(cursor <= list.size() - 1){
            return true;
        }
        return false;
    }
}
