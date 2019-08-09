package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:11:25
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        if (root.left != null) return minDepth(root.left) + 1;
        if (root.right != null) return minDepth(root.right) + 1;
        return 1;
    }
}
