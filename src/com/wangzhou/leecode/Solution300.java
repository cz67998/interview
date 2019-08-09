package com.wangzhou.leecode;

import java.util.Arrays;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/29
 * Time:15:22
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        int[] dp=new int[n];
        Arrays.fill(dp,1 );
        int max=1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j])dp[i]=Math.max(dp[i],dp[j]+1 );
                max=Math.max(max,dp[i]);
            }
        }
        return max;
    }
    public static void main(String[] args){
        Solution300 solution300=new Solution300();
        System.out.println(solution300.lengthOfLIS(new int[]{0}));
    }
}
