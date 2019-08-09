package com.wangzhou.leecode;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/30
 * Time:21:27
 **/
public class Solution129 {
    public int sumNumbers(TreeNode root) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        path(root, new ArrayList<Integer>(), paths);
        int sum=0;
        for (int i = 0; i < paths.size(); i++) {
            int num=0;
            for (int i1 = 0; i1 < paths.get(i).size(); i1++) {
                num=num*10+paths.get(i).get(i1) ;
            }
            sum+=num;
        }
        return sum;
    }

    private void path(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (root == null) return;
        path = new ArrayList<Integer>(path);
        path.add(root.val);
        if (root.right == null && root.left == null) paths.add(path);
        if (root.right != null) path(root.right, path, paths);
        if (root.left != null) path(root.left, path, paths);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        Solution129 solution129=new Solution129();
        System.out.println(solution129.sumNumbers(root));
    }
}
