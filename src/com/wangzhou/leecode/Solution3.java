package com.wangzhou.leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/21
 * Time:14:50
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution3 {
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n == 0) return 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;
        while (right < n) {
            char c = s.charAt(right);
            int count = window.getOrDefault(c, 0);
            window.put(c, count + 1);
            while (window.get(c).intValue() > 1) {
                char c1 = s.charAt(left);
                if (window.containsKey(c1)) {
                    window.put(c1, window.get(c1) - 1);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }


    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (; end < n; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) start = Math.max(start, map.get(c));
            ans = Math.max(ans, end - start + 1);
            map.put(c, end + 1);
        }
        return ans;
    }


    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char al = s.charAt(end);
            if (map.containsKey(al)) {
                start = Math.max(map.get(al), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(al, end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring2("aa"));

    }
}
