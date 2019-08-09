package com.wangzhou.leecode;

import java.util.*;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/16
 * Time:9:23
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution103 {
    private List<List<Integer>> listAll = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return listAll;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;    //标记符
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (flag) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            listAll.add(new ArrayList<>(list));
            list.clear();
            flag=!flag;
        }
        return listAll;
    }
}
