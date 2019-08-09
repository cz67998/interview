package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/30
 * Time:14:44
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        if (length == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '0') zeros++;
                else ones++;

            }
            for (int j = m; j >=zeros ; j--) {
                 for (int k=n;k>=ones;k--){
                     dp[j][k]=Math.max(dp[j][k],1+dp[j-zeros][k-ones]);
                 }
            }
        }
        return dp[m][n];
    }
}
