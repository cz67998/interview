package com.wangzhou.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/5
 * Time:10:23
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution60 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) return listAll;
        queue.add(pRoot);
        int now = 1, next = 0;
        while (!queue.isEmpty()) {
            now--;
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            if (now == 0) {
                listAll.add(new ArrayList<>(list));
                list.clear();
                now = next;
                next = 0;
            }
        }
        return listAll;
    }
}
