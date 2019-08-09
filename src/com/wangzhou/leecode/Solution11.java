package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/9
 * Time:15:59
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution11 {

    public int maxArea(int[] height) {
        int n = height.length;
        if (n <= 1) return 0;
        int max = (n - 1) * Math.min(height[0], height[n-1]);
        for (int i = 0; i < n; i++) {
            int l = i, r = n - 1;
            while (l < r) {
                int num = (r - l) * Math.min(height[l], height[r]);
                if (num > max) {
                    max = num;
                }
                r--;
            }
        }
        return max;
    }
    public static void main(String[] args){
        Solution11 solution11=new Solution11();
        System.out.println(solution11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
