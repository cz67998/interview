package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:11:37
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null)return null;
        TreeNode temp=invertTree(root.left);
        root.left=invertTree(root.right);
        root.right=temp;
        return root;
    }
}
