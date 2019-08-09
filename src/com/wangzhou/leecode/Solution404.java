package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:15:50
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution404 {
    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        helper(root, null);
        return res;
    }

    private void helper(TreeNode root, TreeNode pre) {
        if(root==null)return;
        if(root.left==null&&root.right==null&&pre!=null&&pre.left==root){
            res+=root.val;
        }
        helper(root.left,root);
        helper(root.right,root);
    }


}
