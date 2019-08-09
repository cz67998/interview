package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/9
 * Time:15:57
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution125 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if (n == 0) return true;
        String regex="[^0-9a-zA-Z]";
        String str=s.replaceAll(regex,"");
        String s1=str.toLowerCase();
        System.out.println(s1);
        char[] chars=s1.toCharArray();
        int length=chars.length;
        for (int i = 0; i < length / 2; i++) {
            if(chars[i]!=chars[length-i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution125 solution125=new Solution125();
        System.out.println(solution125.isPalindrome( "race a car"));
    }
}