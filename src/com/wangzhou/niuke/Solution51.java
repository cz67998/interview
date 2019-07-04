package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:20:26
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution51 {
    public int[] multiply(int[] A) {
        int n = A.length;
        if (n == 0) return A;
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = mult(A, i);
        }
        return B;
    }

    private int mult(int[] a, int i) {
        int mul =1;
        for (int i1 = 0; i1 < a.length; i1++) {
            if (i1 != i) {
                mul = mul * a[i1];
            }
        }

        return mul;
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        int[] B = solution51.multiply(new int[]{1, 2, 3, 4, 5});
        for (int i : B) {
            System.out.println(i);
        }
    }
}
