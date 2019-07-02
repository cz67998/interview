package com.wangzhou;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/29
 * Time:17:29
 **/
public class Main {
    public static void main(String[] args){

        Queue q = new LinkedList();
        q.add(1);
        q.add(2);
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
