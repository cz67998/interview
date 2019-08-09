package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/28
 * Time:17:38
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution337 {
    public int rob(TreeNode root){
        return doRob(root);
    }
    private int doRob(TreeNode node){
        if(node==null)return 0;
        int include=node.val;
        int exc=doRob(node.left)+doRob(node.right);
        if(node.left!=null){
            include+=doRob(node.left.left);
            include+=doRob(node.left.right);
        }
        if(node.right!=null){
            include+=doRob(node.right.left);
            include+=doRob(node.right.right);
        }
        return Math.max(include,exc );
    }


}
