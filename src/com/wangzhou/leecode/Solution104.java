package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:11:22
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution104 {
    public int maxDepth(TreeNode root) {
        return root==null?0:Math.max(maxDepth(root.right), maxDepth(root.left))+1;
    }
}
