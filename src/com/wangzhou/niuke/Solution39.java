package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/2
 * Time:8:36
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        return Math.abs(isAvl(root.left) - isAvl(root.right)) <= 1 &&
                IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int isAvl(TreeNode root) {
        if (root == null) return 0;
        int left = isAvl(root.left);
        int right = isAvl(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.left = right;
        Solution39 solution39 = new Solution39();
        System.out.println(solution39.IsBalanced_Solution(root));
    }
}
