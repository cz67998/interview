package com.wangzhou.leecode;

import java.util.HashSet;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/8/3
 * Time:18:38
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0) return false;
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean word_Break(String s, HashSet wordDict, int start, Boolean[] memo) {
        if(start==s.length())return true;
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start+1; end <= s.length(); end++) {
            if(wordDict.contains(s.substring(start,end))&&word_Break(s,wordDict,end,memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
