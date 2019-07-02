package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/4
 * Time:16:24
 **/
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return 2;
        }
        int k = 2;
        for (int i =2; i < n; i++) {
            if(nums[k-2]!=nums[i]){
                nums[k++]=nums[i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
        return k;
    }
    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }
    public static void main(String[] args){
        Solution80 solution80=new Solution80();
        System.out.println(solution80.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
