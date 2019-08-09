package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/8/9
 * Time:10:01
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution53 {

    public int maxSubArray1(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray1(new int[]{-2,1,-3}));
    }
}
