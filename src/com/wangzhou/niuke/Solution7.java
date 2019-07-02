package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/25
 * Time:15:57
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution7 {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        System.out.println(solution7.Fibonacci(0));
        System.out.println(solution7.Fibonacci(1));
        System.out.println(solution7.Fibonacci(2));
        System.out.println(solution7.Fibonacci(3));
        System.out.println(solution7.Fibonacci(4));
        System.out.println(solution7.Fibonacci(5));
    }
}
