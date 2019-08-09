package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/8/9
 * Time:14:50
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution5 {
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (idPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    public boolean idPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }

    public String longestPalindrome1(String s) {
        int length = s.length();
        if (length == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L=left,R=right;
        while (L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        return R-L-1;
    }
}
