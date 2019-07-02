package com.wangzhou.reflect;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/10
 * Time:16:58
 **/
public class Robot {
    static {
        System.out.println("Hello Wz");
    }
    private String name;
    private static String age;
    public  void sayHi(String hello){
        System.out.println(hello+" "+this.name);
    }
    private   String throwHello(String hello,String name){
        return "Hello "+hello+" "+name;
    }
}
