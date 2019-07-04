package com.wangzhou.niuke;

import java.util.HashMap;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:17:57
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution50 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length == 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : numbers) {
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        for (int i = 0; i < length; i++) {
           if(map.get(numbers[i])==2){
               duplication[0]=  numbers[i];
               return true;
           }
        }
        return false;
    }
    public static void main(String[] args){
        Solution50 solution50=new Solution50();
        System.out.println(solution50.duplicate(new int[]{2,3,1,0,2,5,3}
        , 7, new int[1]));
    }
}
