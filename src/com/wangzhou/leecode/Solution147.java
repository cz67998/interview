package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/14
 * Time:22:16
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode node = new ListNode(-1);
        ListNode current = head;
        while (current != null) {
            ListNode dummy=node,next=current.next;
            while (dummy.next!=null&&dummy.next.val<current.val){
                dummy=dummy.next;
            }
            current.next=dummy.next;
            dummy.next=current;
            current=next;
        }
        return node.next;
    }
}
