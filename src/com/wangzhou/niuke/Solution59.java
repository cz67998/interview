package com.wangzhou.niuke;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/5
 * Time:8:59
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution59 {
    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        if(pRoot==null)return listAll;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);
        int now = 1, next = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {

            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    now--;
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if (node.left != null) {
                        stack2.push(node.left);
                        next++;
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                        next++;
                    }
                }
                if (now == 0) {
                    listAll.add(new ArrayList<>(list));
                    list.clear();
                    now = next;
                    next = 0;
                }

            } else {
                while (!stack2.isEmpty()) {
                    now--;
                    TreeNode node = stack2.pop();
                    list.add(node.val);

                    if (node.right != null) {
                        stack1.push(node.right);
                        next++;
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                        next++;
                    }
                }
                if (now == 0) {
                    listAll.add(new ArrayList<>(list));
                    list.clear();
                    now = next;
                    next = 0;
                }
            }

        }
        return listAll;
    }


    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        System.out.println(solution59.Print1(root));
    }
}
