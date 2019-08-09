package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:17:38
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
