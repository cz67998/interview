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
}
