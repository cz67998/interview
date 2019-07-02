package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/27
 * Time:14:08
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution26 {
    public TreeNode1 Convert(TreeNode1 pRootOfTree) {
        if (pRootOfTree == null) return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;
        TreeNode1 left = Convert(pRootOfTree.left);
        TreeNode1 p = left;
        while (p != null && p.right != null) {
            p = p.right;
        }
        if (left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        TreeNode1 right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left != null ? left : pRootOfTree;
    }
    public TreeNode1 Convert1(TreeNode1 pRootOfTree) {
        if(pRootOfTree==null)return null;
        if(pRootOfTree.right==null&&pRootOfTree.left==null)return pRootOfTree;
        TreeNode1 left=Convert1(pRootOfTree.left);
        TreeNode1 p = left;
        while (p != null && p.right != null){
           p=p.right;
        }
        if (left!=null){
            p.right=pRootOfTree;
            pRootOfTree.left=p;
        }
        TreeNode1 right=Convert1(pRootOfTree.right);
        if (right!=null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left!=null?left:pRootOfTree;
    }
    public static void main(String[] args) {

    }
}
