package com.wangzhou.leecode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/28
 * Time:18:05
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] sell = new int[n];
        int[] buy = new int[n];
        int[] cooldown = new int[n];
        buy[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            cooldown[i] = Math.max(cooldown[i - 1], Math.max(sell[i - 1], buy[i - 1]));
        }
        for (int i : sell) {
            System.out.println(i);
        }
        return sell[n - 1];
    }

    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        System.out.println(solution309.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
