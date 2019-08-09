package com.wangzhou.leecode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:16:54
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if ("..".equals(s)) {
                if(!stack.isEmpty())
                stack.pop();
            } else if (s.length()!=0&&!".".equals(s)) {
                stack.push(s);
            }
        }
        StringBuilder res = new StringBuilder();
        Iterator iterator = stack.iterator();
        while (iterator.hasNext()){
            res.append("/"+iterator.next());
        }
        return res.length()==0?"/":res.toString();
    }


    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
        System.out.println(solution71.simplifyPath("/../"));
    }
}
