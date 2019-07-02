package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/4
 * Time:16:21
 **/
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int k = 0;
        if (n <= 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                if (i != k) {
                    swap(nums, i, k++);
                } else {
                    k++;
                }
            }
        }
        return k;
    }

    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
    public static void main(String[] args){
        Solution27 solution27=new Solution27();
        System.out.println(solution27.removeElement(new int[]{3,2,2,3}, 3));
    }
}
