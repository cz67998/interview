package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/26
 * Time:9:01
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution13 {
    public void reOrderArray(int[] array) {
        int n = array.length;
        int m = 0;
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[i] = array[i];
        }
        for (int i = 0; i < n; i++) {
            if (newArray[i] % 2 == 1) {
               array[m++]=newArray[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (newArray[i] % 2 == 0) {
                array[m++]=newArray[i];
            }
        }
    }
}
