package com.wangzhou;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/20
 * Time:9:28
 **/
public class ExtendsTest {
    ExtendsTest(String s){
        System.out.println("b");
    }
}
class Wz extends ExtendsTest{

    Wz(String s) {
        super(s);
        System.out.println("c");
    }
    public static void main(String[] args){
        Wz wz=new Wz("s");
    }
}
