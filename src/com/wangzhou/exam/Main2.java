package com.wangzhou.exam;

import java.util.Scanner;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:20:15
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Main2 {
    public static int meth(int n, int[] nums) {
        if(n==0)return nums[0];
        if(n==1)return Math.abs(nums[0]-nums[1]);
        for (int i = 0; i < n; i++) {
            int e=nums[i];
            int j = i;
            for (; j >0&&nums[j-1]>e; j--) {
                nums[j]=nums[j-1];
            }
            nums[j]=e;
        }

        return nums[n-1]-nums[n-3];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints=new int[n];
        Scanner sc1 = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            ints[i]=sc1.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int e=ints[i];
            int j = i;
            for (; j >0&&ints[j-1]>e; j--) {
                ints[j]=ints[j-1];
            }
            ints[j]=e;
        }
        System.out.println(ints[n-1]-ints[n-3]);
    }
}
