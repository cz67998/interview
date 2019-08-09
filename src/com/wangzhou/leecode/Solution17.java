package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/24
 * Time:13:59
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution17 {
    private List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length()==0) return list;
        String s = "";
        findCombination(digits, 0, s);
        return list;
    }

    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            list.add(s);
            return;
        }
        char[] chars = digits(digits.charAt(index) + "").toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String s1=s;
            s1 += chars[i] + "";
            findCombination(digits, ++index, s1);
            index--;
        }
    }

    private String digits(String s) {
        if ("2".equals(s)) return "abc";
        if ("3".equals(s)) return "def";
        if ("4".equals(s)) return "ghi";
        if ("5".equals(s)) return "jkl";
        if ("6".equals(s)) return "mno";
        if ("7".equals(s)) return "pqrs";
        if ("8".equals(s)) return "tuv";
        if ("9".equals(s)) return "wxyz";
        return "";
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations(""));
    }
}
