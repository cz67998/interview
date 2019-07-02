package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/4
 * Time:16:23
 **/
public class Solution26 {
    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[k]) {
                if(i!=k){
                    nums[++k] = nums[i];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
        return k + 1;
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return 0;
        }
        int k = 1;
        int temp = nums[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    nums[i] = temp;
                }
            }
            if (nums[i] != temp) {
                if (i != k) {
                    swap(nums, i, k++);
                } else {
                    k++;
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(nums[i]);
//        }
        return k;
    }

    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        System.out.println(solution26.removeDuplicates1(new int[]{1,1,1,2}));
    }
}
