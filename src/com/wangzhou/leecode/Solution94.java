package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:17:38
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution94 {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        Solution94 solution94 = new Solution94();
        System.out.println(solution94.inorderTraversal1(root));
    }

    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrder(root);
        return list;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
