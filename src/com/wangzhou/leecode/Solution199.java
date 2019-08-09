package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/16
 * Time:10:17
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                if(i==size-1)list.add(cur.val);
            }
        }
        return list;
    }
}
