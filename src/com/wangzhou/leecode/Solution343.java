package com.wangzhou.leecode;

import static jdk.nashorn.internal.objects.NativeMath.max;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/26
 * Time:16:18
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution343 {


    private int[] memo;

    public int integerBreak1(int n) {
        memo = new int[n + 1];
        if (n == 1) return 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    public int integerBreak(int n) {
        memo = new int[n + 1];
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1) return 1;
        if (memo[n] != 0) return memo[n];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n - 1; i++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
//    public static void main(String[] args){
//        System.out.println(Integer.parseInt(String.valueOf(Math.sqrt(2))));
//    }
}
