package com.wangzhou.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/11
 * Time:13:47
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int num:nums){
            if (set.contains(num))return true;
            set.add(num);
        }
        return false;
    }


    public static void main(String[] args){
        Solution217 solution217=new Solution217();
        System.out.println(solution217.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(solution217.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(solution217.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
