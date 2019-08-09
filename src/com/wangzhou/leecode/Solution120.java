package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/26
 * Time:14:12
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        int[] dp=new int[row];
        for (int i = 0; i < row; i++) dp[i]=triangle.get(row-1).get(i);
        for (int i = row-2; i >=0 ; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);
        List<List<Integer>> triangle=new ArrayList<>();
        triangle.add(list);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        Solution120 solution120=new Solution120();
        System.out.println(solution120.minimumTotal(triangle));
    }
}
