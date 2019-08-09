package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:15:14
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution112 {


    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) return sum == 0;
        return hasPathSum(root.right, sum) || hasPathSum(root.left, sum);
    }
}
