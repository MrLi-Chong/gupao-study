package com.gupao.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/4/18 13:32
 */
public class PathDirectory extends Directory {

    private List<Directory> list ;
    private Integer level;
    public PathDirectory(String name,Integer level) {
        super(name);
        this.level = level;
        list = new ArrayList<Directory>();
    }

    public boolean add(Directory directory){
        return this.list.add(directory);
    }

    public boolean remove(Directory directory){
        return this.list.remove(directory);
    }

    public Directory getDir(int index){
        return this.list.get(index);
    }

    @Override
    public void showName() {
        for (Directory dir:this.list) {
            if(this.level != null){
                for(int j = 0 ;j< this.level;j++){
                    System.out.print("  ");
                }
                for (int k = 0;k < this.level;k++){
                    if(k == 0){
                        System.out.print("+");
                    }
                    if(this.level-1 == k){
                        System.out.print("-");
                    }
                }
            }
            dir.showName();
        }
    }
}
