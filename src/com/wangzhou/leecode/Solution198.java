package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/28
 * Time:14:32
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution198 {
    private int[] memo;


    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n + 1];

        return tryRob1(n - 1, nums, n);
    }

    //[0...x]
    private int tryRob1(int index, int[] nums, int n) {
        if (index < 0) return 0;
        if (memo[index] != 0) return memo[index];
        int res = 0;
        for (int i = 0; i <= index; i++) {
            res = Math.max(res, nums[i] + tryRob1(i - 2, nums, n));
        }
        memo[index] = res;
        return res;

    }

    public int rob3(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] memo = new int[n + 1];
        memo[0] = nums[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=i; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j - 2 >0 ? memo[j - 2] : 0));
            }
        }
        return memo[n];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] memo = new int[n ];
        memo[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }

    //[x....n-1]
    private int tryRob(int index, int[] nums, int n) {
        if (index >= n) return 0;
        if (memo[index] != 0) return memo[index];
        int res = 0;
        for (int i = index; i < n; i++) {
            res = Math.max(res, nums[i] + tryRob(i + 2, nums, n));
        }
        memo[index] = res;
        return res;
    }

    public int rob1(int[] nums) {
        int premax = 0;
        int curmax = 0;
        for (int i : nums) {
            int temp = curmax;
            curmax = Math.max(curmax, premax + i);
            premax = temp;
        }
        return curmax;
    }


    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob2(new int[]{1, 2, 3, 1}));
    }
}
