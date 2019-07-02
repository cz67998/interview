package com.wangzhou.io;

import java.io.Serializable;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/18
 * Time:16:17
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private int age;
    private transient double salary;



    public User() {
    }

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
