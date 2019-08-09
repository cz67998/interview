package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/9
 * Time:14:20
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m;
        for (int i = 0; i < n; i++) {
            nums1[k++]=nums2[i];
        }
        for (int i = 0; i < m + n; i++) {
            int e=nums1[i];
            int j=i;
            for (; j >0&&nums1[j-1]>e ; j--) {
                nums1[j]=nums1[j-1];
            }
            nums1[j]=e;
        }

        for(int i:nums1){
            System.out.println(i);
        }
    }
    public static void main(String[] args){
        Solution88 solution88=new Solution88();
        solution88.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
