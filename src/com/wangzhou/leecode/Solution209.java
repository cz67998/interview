package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/10
 * Time:9:13
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int l = 0, r = -1;
        int sum = 0;
        int num = n + 1;
        while (l < n) {
            if (r + 1 < n && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }
            if (sum >= s) {
                num = Math.min(num, r-l + 1);
            }
        }
        if(num==n+1)return 0;
        return num;
    }
}
