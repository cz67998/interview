package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/30
 * Time:15:08
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if(m==0)return true;
        if(n==0)return false;
        int si=m-1,ti=n-1;
        while (si>=0&&ti>=0){
            char sc=s.charAt(si),tc=t.charAt(ti);
            if(sc==tc){
                si--;
                ti--;
            }else {
                ti--;
            }
        }
        return si==-1;
    }
    public static void main(String[] args){
        Solution392 solution392=new Solution392();
        System.out.println(solution392.isSubsequence("abc","ahbgdc" ));
        System.out.println(solution392.isSubsequence("axc","ahbgdc" ));
    }
}
