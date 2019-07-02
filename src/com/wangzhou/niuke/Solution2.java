package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/24
 * Time:17:16
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        int n = s.length();
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < n; i++) {
            String temp = s.charAt(i) + "";
            if (!temp.equals(" ")) {
                newStr.append(temp);
            } else {
                newStr.append("%20");
            }
        }
        return newStr.toString();
    }
    public static void main(String[] args){
        Solution2 solution2=new Solution2();
        StringBuffer newStr = new StringBuffer("helloworld ");
        solution2.replaceSpace(newStr);
    }
}
