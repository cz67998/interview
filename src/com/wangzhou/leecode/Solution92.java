package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/12
 * Time:15:55
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode con = prev, tail = cur;
        while (n > 0) {
            ListNode next = cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
            n--;
        }
        if(con!=null){
            con.next=prev;
        }else {
            head=prev;
        }
        tail.next=cur;
        return head;
    }
}
