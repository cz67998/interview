package com.wangzhou.niuke;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/4
 * Time:21:41
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution58 {
    boolean isSymmetrical(TreeNode1 pRoot) {
        if (pRoot == null) return true;
        if (pRoot.left == null && pRoot.right == null) return true;
        TreeNode1 root = copy(pRoot);
        TreeNode1 mirror = mirror(root);
        return isSymm(pRoot, mirror);
    }

    private TreeNode1 copy(TreeNode1 pRoot) {
        TreeNode1 root = new TreeNode1(pRoot.val);
        if (pRoot.left != null) {
            root.left=copy(pRoot.left);
        }
        if (pRoot.right != null) {
            root.right = copy(pRoot.right);
        }
        return root;
    }

    private boolean isSymm(TreeNode1 root, TreeNode1 mirror) {
        if (root == null && mirror == null) return true;
        if(root == null || mirror == null)return false;
        return root.val == mirror.val && isSymm(root.left, mirror.left) && isSymm(root.right, root.right);
    }

    private TreeNode1 mirror(TreeNode1 pRoot) {
        if (pRoot == null) return null;
        TreeNode1 left = mirror(pRoot.left);
        TreeNode1 right = mirror(pRoot.right);
        pRoot.right = left;
        pRoot.left = right;
        return pRoot;
    }

    public static void main(String[] args) {
        TreeNode1 head = new TreeNode1(0);
        head.left = new TreeNode1(1);
        head.right = new TreeNode1(1);
        head.left.left=new TreeNode1(1);
        Solution58 solution58 = new Solution58();
        System.out.println(solution58.isSymmetrical(head)) ;
    }
}
