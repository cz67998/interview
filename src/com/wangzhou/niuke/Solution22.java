package com.wangzhou.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:10:06
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode1 root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode1> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode1 treeNode1 = queue.poll();
            if (treeNode1.left != null) {
                queue.add(treeNode1.left);
            }
            if (treeNode1.right != null) {
                queue.add(treeNode1.right);
            }
            list.add(treeNode1.val);
        }
        return list;
    }
}
