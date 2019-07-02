package com.wangzhou.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/10
 * Time:17:01
 **/
public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //全路径
        Class c = Class.forName("com.wangzhou.reflect.Robot");
        //创建对象
        Robot r = (Robot) c.newInstance();
        System.out.println(c.getName());
        //不能获取继承的方法   可获取private方法
        Method getHello = c.getDeclaredMethod("throwHello", String.class,String.class);
        //私有属性，设置为true
        getHello.setAccessible(true);
        Object str = getHello.invoke(r, "Bob","Tom");
        System.out.println(str);
       // r.sayHi("hello")
        // 获取public的方法，包括继承的方法
        Method sayHi=c.getMethod("sayHi", String.class);
        sayHi.invoke(r,"welcome");

        Field name=c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r,"Alice" );
        sayHi.invoke(r,"welcome");

        //获取构造器
        Constructor con=c.getDeclaredConstructor();
        Robot r1 = (Robot) c.newInstance();

        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
