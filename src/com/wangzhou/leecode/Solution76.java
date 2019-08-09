package com.wangzhou.leecode;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/10
 * Time:17:10
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution76 {
    public String minWindow2(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0 || n == 0) return "";
        int left = 0, right = 0;
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            int count = dict.getOrDefault(c, 0);
            dict.put(c, count + 1);
        }
        int requred = dict.size();
        int formed = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        int[] ans = new int[]{-1, 0, 0};
        while (right < m) {
            char c1 = s.charAt(right);
            if(dict.containsKey(c1) ){
            int count = window.getOrDefault(c1, 0);
            window.put(c1, count + 1);
            if ( window.get(c1).intValue() == dict.get(c1).intValue()) {
                formed++;
            }
            }
            while (left <=right && formed == requred) {
                c1 = s.charAt(left);
                if(ans[0]==-1||ans[0]>right-left+1){
                    ans[0]=right-left+1;
                    ans[1]=left;
                    ans[2]=right;
                }
                if(dict.containsKey(c1)){
                    window.put(c1,window.get(c1)-1);
                    if(window.get(c1).intValue() < dict.get(c1).intValue()){
                        formed--;
                    }
                }

                left++;
            }
            right++;
        }
        return ans[0]==-1?"":s.substring(ans[1], ans[2]+1);
    }


    public String minWindow1(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        // Dictionary which keeps a count of all the unique characters in t.
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }
        // Number of unique characters in t, which need to be present in the desired window.
        int required = dictT.size();
        // Left and Right pointer
        int l = 0, r = 0;
        // formed is used to keep track of how many unique characters in t
        // are present in the current window in its desired frequency.
        // e.g. if t is "AABC" then the window must have two A's, one B and one C.
        // Thus formed would be = 3 when all these conditions are met.
        int formed = 0;
        // Dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        // ans list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};
        while (r < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);
            // If the frequency of the current character added equals to the
            // desired count in t then increment the formed count by 1.
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
            // Try and co***act the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // Save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                // Move the left pointer ahead, this would help to look for a new window.
                l++;
            }
            // Keep expanding the window once we are done co***acting.
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }


    public String minWindow(String s, String t) {
        char[] c = t.toCharArray();
        List<String> list = new ArrayList<>();
        int start = 0;

        for (; start < s.length() - t.length() + 1; start++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c1 : c) {
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);
                } else {
                    map.put(c1, 1);
                }
            }
            if (map.size() == 1 && map.get(t.charAt(0)) == 1) {
                int end = start;
                for (; end < s.length(); end++) {

                    if (map.containsKey(s.charAt(end))) {
                        return s.charAt(end) + "";
                    }
                }
            }
            char c2 = s.charAt(start);
            if (!map.containsKey(c2)) {
                continue;
            }
            if (map.containsKey(c2) && map.get(c2) != 0) {
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) == 0) {
                    map.remove(c2);
                }
            }


            int end = start + 1;
            for (; end < s.length(); end++) {
                char c3 = s.charAt(end);
                if (!map.isEmpty()) {
                    if (map.containsKey(c3) && map.get(c3) != 0) {
                        map.put(c3, map.get(c3) - 1);
                        if (map.get(c3) == 0) {
                            map.remove(c3);
                        }
                    }


                    //到末尾
                    if (map.isEmpty() && end == s.length() - 1) {
                        list.add(s.substring(start, end + 1));
                    }
                } else {
                    list.add(s.substring(start, end));
                    break;
                }
            }

        }
        if (list.size() == 0) {
            return "";
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        System.out.println(solution76.minWindow2("a","a" ));
    }
}
