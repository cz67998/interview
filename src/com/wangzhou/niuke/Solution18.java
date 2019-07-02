package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/26
 * Time:20:30
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution18 {
    public void Mirror(TreeNode1 root) {
        root = mirror(root);
    }

    private TreeNode1 mirror(TreeNode1 root) {
        if (root == null) {
            return root;
        }
        TreeNode1 left = mirror(root.left);
        TreeNode1 right = mirror(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
