package com.wangzhou.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/5
 * Time:11:16
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution63 {
    private ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {

        list.add(num);
        Collections.sort(list);

    }

    public Double GetMedian() {
        int size = list.size();
        if (size % 2 == 1) {
            return (Double.valueOf(String.valueOf(list.get(size / 2))));
        }
        if(size==2){
            return (Double.valueOf(String.valueOf(list.get(0)+ list.get(1) )))/2;
        }
        return (Double.valueOf(String.valueOf(list.get(size / 2) + list.get(size / 2 - 1) )))/2;
    }

    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        solution63.Insert(5);
        System.out.println(solution63.GetMedian());
        solution63.Insert(2);
        System.out.println(solution63.GetMedian());
        solution63.Insert(3);
        System.out.println(solution63.GetMedian());
        solution63.Insert(4);
        System.out.println(solution63.GetMedian());
        solution63.Insert(1);
        System.out.println(solution63.GetMedian());
        solution63.Insert(6);
        System.out.println(solution63.GetMedian());
        solution63.Insert(7);
        System.out.println(solution63.GetMedian());
        solution63.Insert(0);
        System.out.println(solution63.GetMedian());
        solution63.Insert(8);
        System.out.println(solution63.GetMedian());
    }
}
