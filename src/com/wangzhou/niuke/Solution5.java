package com.wangzhou.niuke;

import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/25
 * Time:15:34
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
       return stack1.remove(0);
    }
    public static void main(String[] args){
        Stack<Integer> stack1 = new Stack<Integer>();
        stack1.push(1);
        stack1.push(2);
        System.out.println(stack1.get(0));
    }
}
