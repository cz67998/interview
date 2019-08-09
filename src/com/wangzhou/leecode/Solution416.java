package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/30
 * Time:10:11
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution416 {
    private int[][] memo;
    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n == 0) return true;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 == 1) return false;
        int capacity = sum / 2;
        boolean[] memo=new boolean[capacity+1];
        for (int i = 0; i <=capacity; i++) {
            memo[i]=(nums[0]==i);
        }
        for (int i = 1; i < n; i++) {
            for (boolean b:memo){
                System.out.print(b+",");
            }
            System.out.println();
            for (int j =capacity; j >= nums[i]; j--) {
                memo[j]=memo[j]||memo[j-nums[i]];
            }
        }
        return memo[capacity];
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0) return true;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (sum % 2 == 1) return false;
        int capacity = sum / 2;
        memo = new int[n][capacity + 1];
        return tryPartition(nums, n - 1, capacity);
    }

    private boolean tryPartition(int[] nums, int index, int capacity) {
        if (capacity == 0) return true;
        if (capacity < 0 || index < 0) return false;
        if (memo[index][capacity] != 0) return memo[index][capacity] == 0;
        memo[index][capacity]= (tryPartition(nums, index - 1, capacity) || tryPartition(nums, index - 1, capacity - nums[index]))?1:0;
        return memo[index][capacity]==1;
    }

    public static void main(String[] args){
        Solution416 solution416=new Solution416();
        System.out.println(solution416.canPartition1(new int[]{ 2, 3, 5}));
    }
}
