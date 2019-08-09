package com.wangzhou.leecode.knapsack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/29
 * Time:10:56
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class KnapSack02 {
    private int[] w;
    private int[] v;
    private int length;
    private int[][] memo;

    public int kanpsack(int[] w, int[] v, int capactiy) {
        this.length = w.length;
        if (length == 0) return 0;
        this.w = w;
        this.v = v;
        memo = new int[length][capactiy + 1];
        return memoryBack(length - 1, capactiy);
    }

    private int memoryBack(int index, int capactiy) {
        if (index < 0 || capactiy < 0) return 0;
        if (memo[index][capactiy] != 0) return memo[index][capactiy];
        int res = memoryBack(index - 1, capactiy);
        if (w[index] < capactiy)
            res = Math.max(res, v[index] + memoryBack(index - 1, capactiy - w[index]));
        memo[index][capactiy] = res;
        return res;
    }

    public int kanpsack1(int[] w, int[] v, int capactiy) {
        this.length = w.length;
        if (length == 0) return 0;
        this.w = w;
        this.v = v;
        memo = new int[length][capactiy + 1];
        for (int j = 0; j <= capactiy; j++) {
            memo[0][j] = w[0] <= capactiy ? v[0] : 0;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < capactiy; j++) {
                memo[i][j] = memo[i - 1][j];
                if (w[i] < j) {
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }
        return memo[length - 1][capactiy];
    }
}
