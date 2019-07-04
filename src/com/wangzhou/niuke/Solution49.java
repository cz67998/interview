package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:17:32
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution49 {
    public int StrToInt(String str) {
        int n = str.length();
        if (n == 0) return 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] >= '0' && chars[i] <= '9'||chars[0]=='+'||chars[0]=='-') {

            } else {
               return 0;
            }
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - 48);
            } else {
                num = num * 10;
            }
        }
        if(str.charAt(0)=='-'){
            return -num;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();
        System.out.println(solution49.StrToInt("+123"));

    }
}
