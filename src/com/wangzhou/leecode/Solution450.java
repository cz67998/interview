package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/19
 * Time:11:48
 * Blog:https://blog.csdn.net/qq_38522268/
 **/
public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            } else {
                TreeNode node = root.right;
                TreeNode parent = root;
                while (node.left != null) {
                    parent = node;
                    node = node.left;
                }
                //在右子树上删除node节点
                if (parent.left == node) parent.left = node.right;
                if (parent.right == node) parent.right = node.right;
                node.left = root.left;
                node.right = root.right;
                return node;
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Solution450 solution450 = new Solution450();
        solution450.deleteNode(root, 1);
    }
}
