package com.wangzhou.niuke;

import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:8:45
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int n = pushA.length;
        int m = popA.length;
        if (n <= 0 || m <= 0 || m != n) {
            return false;
        }
        Stack<Integer> stack1 = new Stack();
        int popindex = 0;
        for (int i = 0; i < n; i++) {
            stack1.push(pushA[i]);
            while (!stack1.isEmpty() && stack1.peek() == popA[popindex]) {
                stack1.pop();
                popindex++;
            }
        }
        return stack1.isEmpty();
    }
}
