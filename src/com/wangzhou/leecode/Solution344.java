package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/9
 * Time:15:58
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution344 {
    public void reverseString(char[] s) {
        int n=s.length;
        if(n<=1)return;
        int l=0,r=n-1;
        while (l<r){
            swap(l,r,s);
            l++;
            r--;
        }
    }

    private void swap(int l, int r, char[] s) {
        char temp=s[l];
        s[l]=s[r];
        s[r]=temp;
    }
}
