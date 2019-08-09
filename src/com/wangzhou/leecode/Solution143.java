package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:13:32
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null||head.next==null) return;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head,pre=dummy;
        while (current.next != null) {
            current=current.next;
            pre=pre.next;
        }
        ListNode end=pre.next;
        pre.next=null;
        ListNode next=head.next;
        end.next=next;
        head.next=end;
        reorderList(head.next.next);
    }
    public static void main(String[] args){
        Solution143 solution143=new Solution143();
        ListNode head=LinkNodeUtil.createLinkList(new int[]{1,2,3,4,5},5);
        solution143.reorderList(head);
        System.out.println(head);
    }
}
