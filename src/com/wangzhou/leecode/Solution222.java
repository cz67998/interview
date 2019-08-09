package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:14:40
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
          return countNodes(root.right)+countNodes(root.left)+1;
    }
}
