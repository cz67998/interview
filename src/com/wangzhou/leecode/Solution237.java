package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:10:21
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution237 {
    public void deleteNode(ListNode node) {
      node.val=node.next.val;
      node.next=node.next.next;
    }
    public static void main(String[] args){
        Solution237 solution237=new Solution237();
        ListNode head=LinkNodeUtil.createLinkList(
                new int[]{4,5,1,9},4 );
        solution237.deleteNode(head);
        System.out.println(head);
    }
}
