package com.wangzhou.niuke;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:15:37
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution32 {
    public String PrintMinNumber(int[] numbers) {
        int n = numbers.length;
        if (n == 0) return "";
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strings, (a, b) -> {
            String c1 = a + b;
            String c2 = b + a;
            return c1.compareTo(c2);
        });
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < n; i++) {
            res.append(strings[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.PrintMinNumber(new int[]{3, 3213, 4}));
    }
}
