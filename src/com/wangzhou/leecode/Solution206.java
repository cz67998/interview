package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/12
 * Time:14:52
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution206 {
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre=null;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return first;
    }
}


