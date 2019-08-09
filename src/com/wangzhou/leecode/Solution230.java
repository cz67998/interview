package com.wangzhou.leecode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/19
 * Time:14:40
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Queue<Integer> queue=new LinkedList<>();
        inorder(root,queue);
        for (int i = 0; i < k-1; i++) {
            queue.poll();
        }
        return queue.poll();
    }

    private void inorder(TreeNode root,  Queue<Integer> queue) {
        if(root==null)return;
        inorder(root.left,queue );
        queue.add(root.val);
        inorder(root.right, queue);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(0);
        root.right=new TreeNode(2);
        Solution230 solution230=new Solution230();
        System.out.println( solution230.kthSmallest(root,1));

    }
}
