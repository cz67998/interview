package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:13:56
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution46 {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) return -1;
        int s = 0;
        for (int i = 2; i <= n; i++) {
            s = (s + m) % i;
            System.out.println(s);
        }
        return s;
    }
    public int LastRemaining_Solution1(int n, int m) {
        if(n==0)return -1;
        if(n==1)return 0;
        return (LastRemaining_Solution1(n-1,m )+m)%n;
    }
    public static void main(String[] args){
        Solution46 solution46=new Solution46();
        System.out.println( solution46.LastRemaining_Solution(7,2 ));

    }
}
