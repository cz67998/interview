package com.wangzhou.niuke;

import java.util.HashMap;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/2
 * Time:11:21
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution40 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        num1[0]=-1;
        num2[0]=-1;
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
               if(num1[0]!=-1&&num1[0]!=i){
                   num2[0] = i;
               }else {
                   num1[0] = i;
               }
            }
        }
        System.out.println(num1[0]+""+num2[0]);
    }
    public static void main(String[] args){
        Solution40 solution40=new Solution40();
        solution40.FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5},new int[1] ,new int[1] );

    }
}
