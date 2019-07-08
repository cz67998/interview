package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/26
 * Time:16:54
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution17 {
    public boolean HasSubtree(TreeNode1 root1, TreeNode1 root2) {
        if (root2 == null || root1 == null) {
            return false;
        }

        boolean flag = false;
        if (root1.val == root2.val) {
            flag = isSame(root1, root2);
        }
        if (!flag) {
            flag = HasSubtree(root1.left, root2);
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
        }
        // return isSame(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        return flag;
    }

    private boolean isSame(TreeNode1 root1, TreeNode1 root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val == root2.val) {
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        }
        return false;
    }
}

class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;

    }

    @Override
    public String toString() {
        return  String.valueOf(this.left.val+" "+this.val+" "+this.right.val);
    }
}