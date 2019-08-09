package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/8/9
 * Time:11:16
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution121 {
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length == 0) return 0;
        int min=Integer.MAX_VALUE;
        int max=0;
        for (int i = 0; i < length; i++) {
          if(prices[i]<=min){
              min=prices[i];
          }  else {
              int temp=prices[i]-min;
              if(temp>max){
                  max=temp;
              }
          }
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (length == 0) return 0;
        int max = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max) max = profit;
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) return 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                max = Math.max(max, prices[i] - prices[j]);
            }
        }
        return max < 0 ? 0 : max;
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        System.out.println(solution121.maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }
}
