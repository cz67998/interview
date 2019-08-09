package com.wangzhou.leecode;

import java.util.Arrays;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/30
 * Time:13:56
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution322 {
    private int[] coins;
    private int length;

    //自底向下
    public int coinChange1(int[] coins, int amount) {
        int max = amount + 1;
        int[] memo = new int[max];
        Arrays.fill(memo, max);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
            }
        }
        return memo[amount]>amount?-1:memo[amount];
    }

    public int coinChange(int[] coins, int amount) {
        this.length = coins.length;
        if (length == 0) return 0;
        this.coins = coins;
        return coin(amount, new int[amount]);
    }

    private int coin(int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount - 1] != 0) return count[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coin(amount - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }
}
