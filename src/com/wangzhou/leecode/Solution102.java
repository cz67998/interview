package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:21:41
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution102 {
    private List<List<Integer>> listAll = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return listAll;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            listAll.add(new ArrayList<>(list));
            list.clear();
        }
        return listAll;
    }
}
