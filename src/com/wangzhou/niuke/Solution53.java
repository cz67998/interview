package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:21:09
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution53 {
    public boolean isNumeric(char[] str) {

        String s = String.valueOf(str);
//        s.matches("[+-]?[0-9]*(\\.[0-9]*)?([Ee][+-]?[0-9]{1,})?");
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([Ee][+-]?[0-9]+)?");
    }


    private int index = 0;

    public boolean isNumeric1(char[] str) {
        int n = str.length;
        if (n == 0) return false;
        boolean flag = scanInteger(str, n);
        if(index<n&&str[index] == '.' ){
            index++;
            return flag||scanUnsignInteger(str, n);
        }
        if(index<n&&(str[index] == 'E' || str[index] == 'e') ){
            index++;
            return flag&&scanInteger(str, n);
        }
        return flag&&index==n;
    }

    private boolean scanInteger(char[] str, int n) {
        if (index < n && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignInteger(str, n);
    }

    private boolean scanUnsignInteger(char[] str, int n) {
        int start = index;
        while (index < n && (str[index] >= '0' && str[index] <= '9')) {
            index++;
        }
        return start < index;
    }


}
