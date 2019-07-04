package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:10:19
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution43 {
    public String LeftRotateString(String str, int n) {
        int m = str.length();
        if(m==0)return "";
        String s1=str.substring(0,n);
        String s2=str.substring(n,m);
        s2=s2+s1;
        return s2;
    }
    public static void main(String[] args){
        Solution43 solution43=new Solution43();
        solution43.LeftRotateString("abcdefg",2 );
    }
}
