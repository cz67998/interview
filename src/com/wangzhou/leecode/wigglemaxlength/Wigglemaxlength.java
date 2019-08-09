package com.wangzhou.leecode.wigglemaxlength;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/8/3
 * Time:13:08
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Wigglemaxlength {
    private  char[] s1;
    private  char[] s2;
    private int[][] memo;
    public int wigglemaxlength(char[] s1, char[] s2) {
        int m = s1.length, n = s2.length;
        if(m==0||n==0)return 0;
        this.s1=s1;this.s2=s2;
        memo=new int[m][n];
        return LCS(m-1,n-1);
    }

    private int LCS(int m, int n) {
        if(m<0||n<0)return 0;
        if( memo[m][n]!=0)return memo[m][n];
        memo[m][n]=s1[m]==s2[n]?1+LCS(m-1,n-1):Math.max(LCS(m-1,n ),LCS(m,n-1));
        return memo[m][n];
    }
    public static void main(String[] args){
        Wigglemaxlength wigglemaxlength=new Wigglemaxlength();
        System.out.println(wigglemaxlength.wigglemaxlength(new char[]{'A','B','C','D','D'},new char[]{'A','E','B','D','D'} ));
    }
}
