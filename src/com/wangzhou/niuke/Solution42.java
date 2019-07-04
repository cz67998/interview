package com.wangzhou.niuke;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:9:10
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int n = array.length;
        ArrayList<Integer> list = new ArrayList<>();
        if (n == 0) return list;
        int[] temp = new int[2];
        temp[0] = -1;
        temp[1] = -1;
        for (int i = 0;  temp[1] == -1 && i < n; i++) {
            temp[0]=array[i];
            for (int j = i; j < n; j++) {
                if (array[i] + array[j] == sum) {
                    temp[1]=array[j];
                    break;
                }
            }
        }
        if(temp[1]!=-1){
            list.add(temp[0]);
            list.add(temp[1]);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.FindNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15));

    }
}
