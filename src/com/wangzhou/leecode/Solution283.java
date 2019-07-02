package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/4
 * Time:15:12
 **/
public class Solution283 {
    public void moveZeroes4(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int n=nums.length;
        int k=0;//nums中，[0...k)的元素均为非0的元素
        //遍历到第i个元素，保证[0...i]中的所有非0元素
        //都按照顺序排列在[0,,,k)中
        //同时[k,i)为0
        for (int i = 0; i < n; i++) {
            if(nums[i]!=0){
                if(i!=k){
                    swap(nums,i,k++);
                }else {
                    k++;
                }
            }
        }
    }
    public void moveZeroes3(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int n=nums.length;
        int k=0;//nums中，[0...k)的元素均为非0的元素
        //遍历到第i个元素，保证[0...i]中的所有非0元素
        //都按照顺序排列在[0,,,k)中
        //同时[k,i)为0
        for (int i = 0; i < n; i++) {
            if(nums[i]!=0){
                swap(nums,i,k++);
            }
        }
    }

    private void swap(int[] nums, int i, int k) {
        int temp =nums[i];
        nums[i]=nums[k];
        nums[k]=temp;
    }

    public void moveZeroes2(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int n=nums.length;
        int k=0;//nums中，[0...k)的元素均为非0的元素
        for (int i = 0; i < n; i++) {
            if(nums[i]!=0){
              nums[k++]=nums[i];
            }
        }
        for (int i = k; i < n; i++) {
            nums[i]=0;
        }
    }
    public void moveZeroes1(int[] nums) {
        List list =new ArrayList();
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]!=0){
                list.add(nums[i]);
            }
        }
        for (int i = list.size(); i <n ; i++) {
            list.add(0);
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i]=(Integer) list.get(i);
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int n = nums.length;

        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        int a = 0;
        int b = n - 1;
        for (int i = 0; i < n; i++) {
            if (temp[i] == 0) {
                nums[b--] = 0;
            } else {
                nums[a++] = temp[i];
            }
        }
        temp = null;
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        solution283.moveZeroes3(new int[]{0, 1, 0, 3, 12});
    }
}
