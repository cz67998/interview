package com.wangzhou.leecode;

import java.util.Arrays;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/30
 * Time:14:46
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length, n = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, gi = m - 1, si = n - 1;
        while (gi >= 0 && si >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                si--;
                gi--;
            } else {
                gi--;
            }
        }
        return res;
    }
}
