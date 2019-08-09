package com.wangzhou.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/17
 * Time:17:21
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if(root==null)return paths;
        path(root,"",paths);
        return paths;
    }

    private void path(TreeNode root, String s, List<String> paths) {
        if(root==null)return;
        s+=root.val+"";
        if(root.left==null&&root.right==null){
            paths.add(s);
        }else {
            s+="->";
            path(root.right,s,paths);
            path(root.left,s,paths);
        }
    }


    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        path1(root, "", paths);
        return paths;
    }

    private void path1(TreeNode root, String res, List<String> paths) {
        if (root == null) return;
        res += root.val + "";
        if (root.left == null && root.right == null) {
            paths.add(res);
        } else {
            res += "->";
            path1(root.left, res, paths);
            path1(root.right, res, paths);
        }
    }
}
