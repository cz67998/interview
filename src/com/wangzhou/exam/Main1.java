package com.wangzhou.exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:19:31
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Main1 {
    public void test(int n, int[] nums) {
        int length = nums.length;
    }

    public static int meth(int n, int k) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        int m = 1;
        int result = 0;
        while (m * k < sum) {
            int num = 0;
            cal(n, m * k, num);
            result += n;
            m++;
        }
        return result/n%1000000007;
    }

    private static void cal(int n, int num, int nu) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
            for (int i1 = i; i1 < n; i1++) {
                num -= queue.poll();
                if (num == 0) nu++;
                for (int i2 = i1; i2 < n; i2++) {
                    queue.add(i2);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k=sc.nextInt();
         System.out.println(meth(n,k));
    }
}
