package com.wangzhou.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:11:04
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution45 {

    public boolean isContinuous(int[] numbers) {
        int n = numbers.length;
        if (n != 5) return false;
        int[] insertsort = insertsort(numbers);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i : insertsort) {
            if (i == 0) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }
        int m = list1.size();
        if (m == 4) return true;
        if (m == 3) {
            int judge = list2.get(1) - list2.get(0);
            if (judge <= 4 && judge > 0) {
                return true;
            }
        }
        if (m == 2) {
            int judge1 = list2.get(1) - list2.get(0);
            int judge2 = list2.get(2) - list2.get(1);
            if(judge1==3&&judge2==1){
                return true;
            }
            if(judge1==2&&judge2==2){
                return true;
            }
            if(judge1==1&&judge2==3){
                return true;
            }
        }
        if (m == 1) {
            int judge1 = list2.get(1) - list2.get(0);
            int judge2 = list2.get(2) - list2.get(1);
            int judge3 = list2.get(3) - list2.get(2);
            if(judge1==2&&judge2==1&&judge3==1){
                return true;
            }
            if(judge1==1&&judge2==2&&judge3==1){
                return true;
            }
            if(judge1==1&&judge2==1&&judge3==2){
                return true;
            }
        }
        if (m == 0) {
            int judge1 = list2.get(1) - list2.get(0);
            int judge2 = list2.get(2) - list2.get(1);
            int judge3 = list2.get(3) - list2.get(2);
            int judge4 = list2.get(4) - list2.get(3);
            if(judge1==1&&judge2==1&&judge3==1&&judge4==1){
                return true;
            }
        }
        return false;
    }

    private int[] insertsort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int e = numbers[i];
            int j = i;
            for (; j > 0 && numbers[j - 1] > e; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = e;
        }
        return numbers;
    }

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.isContinuous(new int[]{1,0,0,5,0}));
    }
}
