package com.wangzhou.niuke;

import java.util.HashMap;

/**
 * Created by IDEA
 * author:wangzhouSolution34
 * Date:2019/7/1
 * Time:11:13
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution34 {
    public int FirstNotRepeatingChar(String str) {
        int n = str.length();
        if (n == 0) return -1;
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(chars[i]) == 1) {
//                System.out.println(chars[i]);
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        System.out.println(solution34.FirstNotRepeatingChar("google"));

    }
}
