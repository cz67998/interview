package com.wangzhou.leecode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/30
 * Time:14:44
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        // 注意：理解这一句代码的含义
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int d:dp) {
                System.out.print(d);
            }
            System.out.println();
            for (int j = 0; j < len; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        for (int d:dp) {
            System.out.print(d);
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution377 solution377 = new Solution377();
        int d=solution377.combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(d);
    }
}
