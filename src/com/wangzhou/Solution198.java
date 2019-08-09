package com.wangzhou;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/8/2
 * Time:10:19
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution198 {
    private int[] nums;
    private int length;
    private int[] memo;

    public int rob(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        if (length == 0) return 0;
        memo = new int[length + 1];

        return tryRob1(length - 1);
    }

    //[x..n-1]
    private int tryRob(int index) {
        if (index >= length) return 0;
        if (memo[index] != 0) return memo[index];
        int res = 0;
        for (int i = index; i < length; i++) {
            res = Math.max(res, nums[i] + tryRob(i + 2));
        }
        memo[index] = res;
        return res;
    }

    //自底向下[x..n-1]
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] memo = new int[n + 1];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }

    //[0....X]
    private int tryRob1(int index) {
        if (index < 0) return 0;
        if (memo[index] != 0) return memo[index];
        int res = 0;
        for (int i = 0; i <= index; i++) {
            res = Math.max(res, nums[i] + tryRob1(i - 2));
        }
        memo[index] = res;
        return res;
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] memo = new int[n];
        memo[0] = nums[0];
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                memo[i] = Math.max(memo[i], nums[j] + (j - 2 >= 0 ? memo[j - 2] : 0));
            }
        }
        return memo[n - 1];
    }

    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob2(new int[]{1, 2, 3, 1}));

//        List<Integer> list = new ArrayList<>();
////        list.add(1);
////        list.add(2);
////        list.add(3);
////        list.add(4);
////        list.add(5);
//////        for (Integer in:list){
//////            if(in==2){
//////                list.remove(new Integer(2));
//////            }
//////            System.out.print(in);
//////        }
////
//////        for (int i = 0; i < list.size(); i++) {
//////            System.out.print(list.get(i));
//////            if (i == 1) {
//////                list.remove(i);
//////            }
//////        }
//////        System.out.println();
////        for (int i = list.size()-1; i >= 0; i--) {
////            System.out.print(list.get(i));
////            if (i == 1) {
////                list.remove(i);
////            }
////        }
////
//////        Iterator<Integer> iterator = list.iterator();
//////        while (iterator.hasNext()) {
//////            Integer integer = iterator.next();
//////            System.out.println(integer);
//////            if (integer == 2)
//////                iterator.remove();
//////        }
////        for (int i:list){
////            System.out.print(i);
////        }
////
    }
}
