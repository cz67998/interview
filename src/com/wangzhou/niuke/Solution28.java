package com.wangzhou.niuke;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:14:20
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int n = array.length;
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return array[0];
        }
        int mid = n / 2;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) > mid) {
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Solution28 solution28=new Solution28();
        System.out.println( solution28.MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
    }
}
