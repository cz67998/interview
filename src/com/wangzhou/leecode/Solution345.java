package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/9
 * Time:15:58
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution345 {
    public String reverseVowels(String s) {
        int n = s.length();
        if (n <= 1) return s;
        char[] chars=s.toCharArray();
        int l = 0, r = n - 1;
        while (l < r) {
            if (!isTrue(chars[l])) {
              l++;
              continue;
            }
            if (!isTrue(chars[r])) {
                r--;
                continue;
            }
            swap(l, r, chars);
            l++;
            r--;
        }
        return String.valueOf(chars);
    }

    private void swap(int l, int r, char[] c) {
        char temp=c[l];
        c[l]=c[r];
        c[r]=temp;
    }

    private boolean isTrue(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    public static void main(String[] args){
        Solution345 solution345=new Solution345();
        System.out.println(solution345.reverseVowels("leetcode"));
    }

}
