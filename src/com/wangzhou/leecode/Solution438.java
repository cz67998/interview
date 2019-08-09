package com.wangzhou.leecode;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/10
 * Time:17:09
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution438 {
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = s.length(), n = p.length();
        if (m == 0 || n == 0) return list;
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            int count = dict.getOrDefault(c, 0);
            dict.put(c, count + 1);
        }
        int required = dict.size();
        int formed = 0;
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        while (right < m) {
            char c1 = s.charAt(right);
            if (dict.containsKey(c1)) {
                int count = window.getOrDefault(c1, 0);
                window.put(c1, count + 1);
                if (window.get(c1).intValue() == dict.get(c1).intValue()) {
                    formed++;
                }
            }
            while (left <= right && formed == required) {
                c1 = s.charAt(left);
                if (right - left+1== n) list.add(left);
                if (dict.containsKey(c1)) {
                    window.put(c1, window.get(c1) - 1);
                    if (window.get(c1).intValue() < dict.get(c1).intValue()) {
                        formed--;
                    }
                }
                left++;
            }
            right++;
        }
        return list;
    }

    public List<Integer> findAnagrams(String s, String p) {
        Set<Character> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            set.add(p.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            for (int i1 = i + 1; i1 < s.length(); i1++) {
                if (istrue(i, i1, s, set)) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    private boolean istrue(int i, int i1, String s, Set<Character> set) {
        for (int i2 = 0; i2 < i1; i2++) {
            if (set.contains(s.charAt(i2))) {
                return false;
            }
        }
        return true;
    }
}
