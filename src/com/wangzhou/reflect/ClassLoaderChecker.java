package com.wangzhou.reflect;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/11
 * Time:9:17
 **/
public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader m = new MyClassLoader("D:\\Users\\Administrator\\Desktop\\interview\\out\\production\\interview\\", "myClassLoader");
        Class c = m.loadClass("com.wangzhou.reflect.Robot");
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
        System.out.println(c.getClassLoader().getParent().getParent());
       // System.out.println(c.getClassLoader().getParent().getParent().getParent());
        c.newInstance();
    }
}
