package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:11:44
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if((p!=null&&q==null)||(p==null&&q!=null))return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left,q.left )&&isSameTree(p.right, q.right);
    }
}
