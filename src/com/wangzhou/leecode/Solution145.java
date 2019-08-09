package com.wangzhou.leecode;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:17:38
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution145 {
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(0, current.val);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return list;
    }

    private List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return list;
    }

    private void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }
}
