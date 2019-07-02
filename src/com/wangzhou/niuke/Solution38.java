package com.wangzhou.niuke;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/1
 * Time:21:31
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution38 {
    public int TreeDepth(TreeNode1 root) {
        if (root == null) return 0;
        int depth = 0, count = 0, newcount = 1;
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode1 node = queue.poll();
            count++;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (count == newcount) {
                newcount = queue.size();
                depth++;
                count = 0;
            }
        }
        return depth;
    }
    public int TreeDepth1(TreeNode1 root) {
        if (root == null) return 0;
        int left=TreeDepth1(root.left);
        int right=TreeDepth1(root.right);
        return left>right?left+1:right +1;
    }
}

