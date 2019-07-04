package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/3
 * Time:20:36
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution52 {
    public boolean match(char[] str, char[] pattern) {
        int m = str.length;
        int n = pattern.length;
        if (m == 0 && n == 0) return true;
        String s1 = String.valueOf(str);
        String s2 = String.valueOf(pattern);
        return s1.matches(s2);
    }

    public boolean match1(char[] str, char[] pattern) {
        if (str == null || pattern == null) return false;
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) return true;
        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length) return false;
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (strIndex != str.length && pattern[patternIndex] == str[strIndex] ||
                    (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }


    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        System.out.println(solution52.match1(new char[]{}, new char[]{'.', '*'}));
    }
}
