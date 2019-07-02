package com.wangzhou.niuke;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/26
 * Time:21:55
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution20 {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> stack1 = new Stack();

    public void push(int node) {
        stack.push(node);
        if (stack1.isEmpty()) {
            stack1.push(node);
        } else {
            if (node < stack1.peek()) {
                stack1.push(node);
            }
        }
    }

    public void pop() {
        if (stack1.peek() == stack.peek()) {
            stack1.pop();
        }
        stack.pop();


    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack1.peek();
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        solution20.push(4);
        solution20.push(5);
        solution20.pop();
        System.out.println(solution20.min());
        solution20.push(3);
        solution20.push(5);
        System.out.println(solution20.min());

//        Stack<Integer> stack = new Stack();
//        stack.push(4);
//        stack.push(3);
//        stack.push(2);
//        stack.push(1);
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(stack.peek());
    }
}
