package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/30
 * Time:14:45
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution494 {
//    private int[][] memo;
//    public int findTargetSumWays1(int[] nums, int S) {
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        if (sum < S || (sum + S) % 2 == 1) {
//            return 0;
//        }
//        int C = (sum + S) / 2;
//        memo=new int[nums.length][C];
//        return word_Break(nums, nums.length-1, C);
//    }
//
//    public int word_Break(int[] nums, int index, int C) {
//        if (index<0||C<0)return 0;
//        if (memo[index][C] != 0) return memo[index][C];
//        return 0;
//    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int w = (sum + S) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i:dp){
                System.out.print(i);
            }
            System.out.println();
            for (int i = w; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        Solution494 solution494 = new Solution494();
        System.out.println(solution494.findTargetSumWays(new int[]{1, 3, 1, 1, 1}, 3));
    }
}
