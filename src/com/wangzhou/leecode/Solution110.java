package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:14:54
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBanance(root) >= 0;
    }

    private int isBanance(TreeNode root) {
        if(root==null)return 0;
        int a = isBanance(root.left);
        int b = isBanance(root.right);
        if(a>=0&&b>=0&&Math.abs(b-a)<=1){
            return Math.max( a,b)+1;
        }
        return -1;
    }
}
