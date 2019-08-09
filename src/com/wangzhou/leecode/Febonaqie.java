package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/26
 * Time:11:10
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Febonaqie {
    private int[] memo = new int[10000];

    public int febo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (memo[n] == 0) {
            memo[n] = febo(n - 1) + febo(n - 2);
        }
        return memo[n];
    }

    //自底向下
    public int febo1(int n) {
        int[] memo=new int[n+1];
        memo[0]=0;
        memo[1]=1;
        for (int i = 2; i <=n; i++) {
            memo[i]=memo[n-1]+memo[n-2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Febonaqie febonaqie = new Febonaqie();
        long startTime = System.nanoTime();
        System.out.println(febonaqie.febo(1000));
        long endTime = System.nanoTime();
        System.out.println((double) (endTime - startTime) / 1000000000 + "(s)");
    }
}
