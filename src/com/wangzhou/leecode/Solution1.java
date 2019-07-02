package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/30
 * Time:21:27
 **/
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                if (i == i1) {
                    continue;
                }
                if (nums[i] + nums[i1] == target) {
                    result[0] = i;
                    result[1] = i1;
                    return result;
                }
            }
        }
        return null;
    }
}
