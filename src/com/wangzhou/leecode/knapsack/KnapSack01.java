package com.wangzhou.leecode.knapsack;

import java.util.Arrays;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/29
 * Time:9:15
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class KnapSack01 {
    private int[] w;
    private int[] v;
    private int length;
    private int[][] memo;
    private int[] memo1;

    //动态规划，自底向下,空间复杂度优化O(n)
    public int kanpsack3(int[] w, int[] v, int capactiy) {
        this.length = w.length;
        if (length == 0) return 0;
        memo1 = new int[capactiy + 1];
        for (int j = 0; j <= capactiy; j++) {
            memo1[j] = w[0] <= j ? v[0] : 0;
        }

        for (int i = 1; i < length; i++) {
            for (int j = capactiy; j >= w[i]; j--) {
                memo1[j] = Math.max(memo1[j], v[i] + memo1[j - w[i]]);
            }
        }
        return memo1[capactiy];
    }

    //动态规划，自底向下,空间复杂度优化O(2n)
    public int kanpsack2(int[] w, int[] v, int capactiy) {
        this.length = w.length;
        if (length == 0) return 0;
        memo = new int[2][capactiy + 1];
        for (int j = 0; j <= capactiy; j++) {
            memo[0][j] = w[0] <= j ? v[0] : 0;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= capactiy; j++) {
                memo[i % 2][j] = memo[(i - 1) % 2][j];
                if (j >= w[i]) {
                    memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
                }
            }
        }
        return memo[(length - 1) % 2][capactiy];
    }

    //动态规划，自底向下
    public int kanpsack1(int[] w, int[] v, int capactiy) {
        this.length = w.length;
        if (length == 0) return 0;
        memo = new int[length][capactiy + 1];
        for (int j = 0; j < capactiy; j++) {
            memo[0][j] = w[0] <= j ? v[0] : 0;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= capactiy; j++) {
                if (j >= w[i]) {
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }
        System.out.println("[" + (length - 1) + ":" + capactiy + "]");
        int j = capactiy;
        for (int i = length - 1; i >= 1; i--) {
            if (memo[i - 1][j] == memo[i][j]) {
                System.out.println("[" + (i - 1) + ":" + j + "]");
            }else {
                j=j-w[i];
                System.out.println("[" + (i - 1) + ":" + j + "]");
            }
        }
        return memo[length - 1][capactiy];
    }

    //记忆化搜索，自顶向下
    public int kanpsack(int[] w, int[] v, int capactiy) {
        this.length = w.length;
        if (length == 0) return 0;
        this.w = w;
        this.v = v;
        memo = new int[length][capactiy + 1];
        return memorySearch(length - 1, capactiy);

    }

    //TODO
    private int memorySearch(int index, int capactiy) {
        if (index < 0 || capactiy < 0) return 0;
        if (memo[index][capactiy] != 0) return memo[index][capactiy];
        int res = 0;
        if (capactiy >= w[index]) {
            res = Math.max(memorySearch(index - 1, capactiy), v[index] + memorySearch(index - 1, capactiy - w[index]));
        }
        memo[index][capactiy] = res;
        return res;
//
//        if (index < 0 || capactiy < 0) return 0;
//        if (memo[index][capactiy] != 0) return memo[index][capactiy];
//        int res = memorySearch(index - 1, capactiy);
//        if (capactiy >= w[index])
//            res = Math.max(res, v[index] + memorySearch(index - 1, capactiy - w[index]));
//        memo[index][capactiy] = res;
//        return res;
    }

    public static void main(String[] args) {
        KnapSack01 knapSack01 = new KnapSack01();
        System.out.println(knapSack01.kanpsack1(new int[]{1, 2, 3}, new int[]{6, 10, 12}, 5));
    }
}
