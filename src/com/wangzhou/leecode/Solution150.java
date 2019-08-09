package com.wangzhou.leecode;

import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:16:33
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            String regex = "[+-]?[0-9]+";
            if (s.matches(regex)) stack.push(s);
            if ("+".equals(s)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.add(a + b + "");
            }
            if ("*".equals(s)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.add(a * b + "");
            }
            if ("-".equals(s)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.add((a - b) + "");
            }
            if ("/".equals(s)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                stack.add((a / b) + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        Solution150 solution150=new Solution150();
        System.out.println(solution150.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
