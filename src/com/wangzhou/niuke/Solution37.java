package com.wangzhou.niuke;

import java.util.HashMap;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/1
 * Time:21:23
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution37 {
    public int GetNumberOfK(int[] array, int k) {
        int n = array.length;
        if (n == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i:array) {
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1 ) ;
            }else {
                map.put(i,1 ) ;
            }
        }

        if(map.get(k)!=null){
            return map.get(k);
        }else {
            return 0;
        }

    }
    public static void main(String[] args){
        Solution37 solution37=new Solution37();
        System.out.println(solution37.GetNumberOfK(new int[]{1,3,3,3,3,4,5},2 ));
    }
}
