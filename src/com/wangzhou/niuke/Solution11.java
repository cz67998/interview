package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/25
 * Time:17:25
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution11 {
    public int NumberOf1(int n) {
        if (n == 0) {
            return 0;
        }
        int i = 1;
        while (n != 1) {
            if (n % 2 == 1) {
                i++;
            }
            n = n / 2;
        }
        return i;
    }
    public int NumberOf11(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.valueOf("01111111111111111111111111111110",2));
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.NumberOf11(0));
        System.out.println(solution11.NumberOf11(1));
        System.out.println(solution11.NumberOf11(2));
        System.out.println(solution11.NumberOf11(3));
        System.out.println(solution11.NumberOf11(-16));
    }
}
