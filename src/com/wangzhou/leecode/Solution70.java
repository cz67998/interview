package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/26
 * Time:11:47
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution70 {
    private int[] sign=new int[Integer.MAX_VALUE];
    public int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        if(sign[n]==0){
            sign[n]=climbStairs(n - 1) + climbStairs(n - 2);
        }
        return  sign[n];
    }
}
