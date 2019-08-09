package com.wangzhou.leecode;

import java.util.HashMap;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/18
 * Time:14:29
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution437 {
    public int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return helper(root, map, sum, 0);
    }

    int helper(TreeNode root, HashMap<Integer, Integer> map, int sum, int pathSum){
        int res = 0;
        if(root == null) return 0;
        pathSum += root.val;
        res += map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        res = helper(root.left, map, sum, pathSum) + helper(root.right, map, sum, pathSum) + res;
        map.put(pathSum, map.get(pathSum) - 1);
        return res;
    }



    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return path(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int path(TreeNode root, int sum) {
        if (root == null) return 0;
        sum -= root.val;
        return (sum == 0 ? 1 : 0) + path(root.left, sum) + path(root.right, sum);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        Solution437 solution437=new Solution437();
        System.out.println(solution437.pathSum1(root,3 ));
    }
}
