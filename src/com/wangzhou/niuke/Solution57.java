package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/4
 * Time:17:50
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
          if(pNode.next.left==pNode)return pNode.next;
          pNode=pNode.next;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}