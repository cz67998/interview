package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/8/9
 * Time:13:48
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int a=cost[0],b=cost[1],c;
        for (int i = 2; i < cost.length; i++) {
            c=a<b?a:b;
            c=c+cost[i];
            a=b;
            b=c;
        }
        return Math.min(a,b );
    }
    public static void main(String[] args){
        Solution746 solution746=new Solution746();
        System.out.println(solution746.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
