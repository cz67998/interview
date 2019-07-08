package com.wangzhou.niuke;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/5
 * Time:10:40
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution62 {
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) return null;
        inTree(pRoot);
        if (k > list.size()) return null;
        return list.get(k - 1);
    }
    ArrayList<TreeNode> list = new ArrayList<>();
    private void inTree(TreeNode node) {
        if (node == null) return;
        inTree(node.left);
        list.add(node);
        inTree(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        Solution62 solution62 = new Solution62();
        solution62.inTree(root);
        System.out.println(solution62.list);

    }
}
