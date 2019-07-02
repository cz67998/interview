package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/4
 * Time:20:29
 **/
public class Solution75 {
    public void sortColors3(int[] nums) {
        int n = nums.length;
        int[] count = new int[3];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int sum=0;
        for (int i = 0; i < count.length; i++) {
            sum+=count[i];
            count[i]=sum;
        }
        int[] temp=new int[n];
        for (int i = 0; i < n; i++) {
           temp[i]=nums[i];
        }
        for(int i=n-1;i>=0;i--){
            nums[count[temp[i]]-1]=temp[i];
            count[temp[i]]--;
        }

    }
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int[] count = new int[3];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        int index=0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++]=0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++]=1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++]=2;
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;
        Comparable[] arr = new Comparable[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        insertSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    // 递归使用快速排序,对arr[left...right]的范围进行排序
    private static void sort(Comparable[] arr, int left, int right) {
        if (left >= right - 15) {
            insertSort(arr, left, right);
            return;
        }
        swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);
        Comparable v = arr[left];
        int lt = left;//arr[left+1...lt]<v
        int i = left + 1;//arr[gt...r]>v
        int gt = right + 1;//arr[lt+1..i]==v
        while (i < gt) {
            if (arr[i].compareTo(v) < 0) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i].compareTo(v) > 0) {
                swap(arr, gt - 1, i);
                gt--;
            } else {
                i++;
            }
        }
        swap(arr, left, lt);
        sort(arr, left, lt - 1);
        sort(arr, gt, right);
    }

    private static void swap(Object[] arr, int j, int i) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void insertSort(Comparable[] arr, int left, int right) {

        for (int i = left + 1; i <= right; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > 1 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public void sortColors(int[] nums) {
        List list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            nums[i] = (int) list.get(i);
        }
    }

    public static void main(String[] args) {
        Solution75 solution75 = new Solution75();
        solution75.sortColors1(new int[]{2, 0, 2, 1, 1, 0});
    }
}
