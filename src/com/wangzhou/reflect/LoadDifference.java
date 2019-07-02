package com.wangzhou.reflect;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/11
 * Time:11:34
 **/
public class LoadDifference {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader c = Robot.class.getClassLoader();
        Class cl = Class.forName("com.wangzhou.reflect.Robot");
        Class.forName("com.mysql.jdbc.Driver");
    }
}
