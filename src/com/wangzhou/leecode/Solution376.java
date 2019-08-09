package com.wangzhou.leecode;

import java.util.Arrays;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/29
 * Time:22:22
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution376 {

    //贪心算法
    public int wiggleMaxLength2(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int pre = nums[1] - nums[0];
        int count = pre == 0 ? 1 : 2;
        for (int i = 2; i < n; i++) {
            int temp = nums[i] - nums[i - 1];
            if ((temp>0&&pre<=0)||(temp<0&&pre>=0)) {
                count++;
                pre=temp;
            }
        }
        return count;
    }

    public int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int[] up = new int[n];
        int[] down = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }
        return 1 + Math.max(down[n - 1], up[n - 1]);
    }

    public static void main(String[] args) {
        Solution376 solution376 = new Solution376();
        System.out.println(solution376.wiggleMaxLength2(new int[]{3, 3, 3, 2, 5}));
    }
}
