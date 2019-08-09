package com.wangzhou.leecode;

import java.util.PriorityQueue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/16
 * Time:20:35
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                priorityQueue.add(cur.val);
                cur = cur.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode listNode=dummy;
        int n= priorityQueue.size();
        for (int i = 0; i <n; i++) {
            listNode.next = new ListNode(priorityQueue.remove());
            listNode=listNode.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();

        System.out.println(solution23.mergeKLists(new ListNode[]{
                LinkNodeUtil.createLinkList(new int[]{1,4,5},3 ),
                LinkNodeUtil.createLinkList(new int[]{1,3,4},3 ),
                LinkNodeUtil.createLinkList(new int[]{2,6},2 ),
        }));
    }
}
