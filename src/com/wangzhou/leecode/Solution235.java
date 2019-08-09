package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/19
 * Time:11:42
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if ((p.val < root.val && q.val >= root.val) || (p.val <= root.val && q.val > root.val)) return root;
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
