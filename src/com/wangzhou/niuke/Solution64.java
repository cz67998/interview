package com.wangzhou.niuke;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/5
 * Time:13:39
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution64 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = num.length;
        if (n == 0||size==0) return list;
        int i = 0;
        while (i + size - 1 <= n-1) {
            int max = max(i, num, size);
            list.add(max);
            i++;
        }
        return list;
    }

    private int max(int i, int[] num, int size) {
        int max = num[i];
        for (int j = i + 1; j <= i + size-1; j++) {
            if (num[j] > max) {
                max = num[j];
            }
        }
        return max;
    }
    public static void main(String[] args){
        Solution64 solution64=new Solution64();
        System.out.println(  solution64.maxInWindows(new int[]{10,14,12,11},0));

    }
}
