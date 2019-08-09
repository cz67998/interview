package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/28
 * Time:16:26
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        int a = max(0, n - 2, nums);
        int b = max(1, n - 1, nums);
        return Math.max(a, b);
    }

    private int max(int start, int end, int[] nums) {
        int premax=0;
        int curmax=0;
        for (int i = start; i <=end; i++) {
            int temp=curmax;
            curmax=Math.max(curmax,premax+nums[i]);
            premax=temp;
        }
        return curmax;
    }

}
