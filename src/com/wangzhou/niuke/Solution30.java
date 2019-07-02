package com.wangzhou.niuke;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:14:57
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i ; j < n; j++) {
                if(j==i){
                    list.add(array[i]);
                }
                int num = add(array, i, j);
                list.add(num);
            }
        }
//        Collections.sort(list);
//        return list.get(list.size()-1);
        int max = list.get(0);
        for (int i : list) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    private int add(int[] array, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += array[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(-1>-11);
        Solution30 solution30=new Solution30();
        System.out.println(solution30.FindGreatestSumOfSubArray(new int[]{-2,-8,-1,-5,-9}));
}
}
