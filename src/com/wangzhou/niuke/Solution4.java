package com.wangzhou.niuke;

import java.util.HashMap;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/24
 * Time:20:06
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution4 {
    private TreeNode node = new TreeNode(0);

    public TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    private TreeNode preIn(int[] pre, int pi, int pj, int[] in, int ii, int ij, HashMap<Integer, Integer> map) {
         if(pi>pj){
             return null;
         }
        TreeNode head=new TreeNode(pre[pi]);
         int index=map.get(pre[pi]);
         head.left=preIn(pre, pi+1, pi+index-ii, in,ii , index-1, map);
         head.right=preIn(pre, pi+index+1-ii,pj , in,index+1 , ij, map);
//        head.left=preIn(pre, 1, index, in,0 , index-1, map);
//        head.right=preIn(pre, index+1,pj , in,index+1 , ij, map);
         return head;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int n = pre.length;
        if (n <= 0) {
            return null;
        }
        int root = pre[0];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (in[i] == root) {
                index = i;
            }
        }
        int[] prel = subInts(pre, 1, index);
        int[] prer = subInts(pre, index + 1, n - 1);
        int[] inl = subInts(in, 0, index - 1);
        int[] inr = subInts(in, index + 1, n - 1);
        node.val = root;
        node.left = reConstructBinaryTree(prel, inl);
        node.right = reConstructBinaryTree(prer, inr);
        return node;
    }

    private int[] subInts(int[] pre, int start, int end) {
        int n = end - start + 1;
        int[] newInts = new int[n];
        int l = 0;
        for (int i = start; i <= end; i++) {
            newInts[l++] = pre[i];
        }
        return newInts;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        solution4.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8},
                new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
