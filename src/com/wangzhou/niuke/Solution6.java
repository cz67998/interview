package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/25
 * Time:15:44
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution6 {
    public int minNumberInRotateArray(int[] array) {
        int n = array.length;
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return array[0];
        }
        int min=array[0];
        for (int i = 1; i < n; i++) {
            if(min>array[i]){
                min=array[i];
            }
        }
        return min;

    }
}
