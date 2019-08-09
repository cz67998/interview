package com.wangzhou.leecode;

import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:16:25
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c) stack.push(c);
            if(stack.isEmpty())
                return false;
            if(')'==c&&stack.pop()!='('){
                return false;
            }
            if('}'==c&&stack.pop()!='{'){
                return false;
            }
            if(']'==c&&stack.pop()!='['){
                return false;
            }
        }
        return stack.isEmpty();
    }
}

