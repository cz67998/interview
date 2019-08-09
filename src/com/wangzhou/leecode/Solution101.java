package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:14:16
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return symertic(root.left,root.right);
    }

    private boolean symertic(TreeNode left, TreeNode right) {
        if(left==null)return right==null;
        if(right==null)return left==null;
        return left.val==right.val&&symertic(left.left,right.right )&&symertic(left.right,right.left );
    }
}
