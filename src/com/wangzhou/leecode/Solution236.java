package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/19
 * Time:14:40
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution236 {
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int mid=root==p||root==q?1:0;
        if(left+right+mid>1)res=root;
        return left+right+mid>0?1:0;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(0);
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);
        Solution236 solution236=new Solution236();
        System.out.println(solution236.lowestCommonAncestor(root,root.left ,root.right).val);
    }
}
