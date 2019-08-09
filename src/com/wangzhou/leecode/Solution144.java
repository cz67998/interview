package com.wangzhou.leecode;


import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:17:37
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution144 {
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add( current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }

        }
        return list;
    }

    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return list;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);

        tree.right.left = new TreeNode(3);
        Solution144 solution144 = new Solution144();
        solution144.preorderTraversal(tree);
        System.out.println(solution144.list);
    }
}
