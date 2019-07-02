package com.wangzhou.innerclass;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/20
 * Time:14:39
 **/
public class Outer4 {
    public static IAnimal getInnerInstance(String speak){
        return new IAnimal(){
            @Override
            public void speak(){
                System.out.println(speak);
            }};
        //注意上一行的分号必须有
    }

    public static void main(String[] args){
        //调用的speak()是重写后的speak方法。
        Outer4.getInnerInstance("小狗汪汪汪！").speak();
    }

}
