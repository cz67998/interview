package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/26
 * Time:11:14
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public ListNode ReverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pnext = pNode.next;
            if (pnext == null) {
                newHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pnext;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        Solution15 solution15 = new Solution15();
        System.out.println(solution15.ReverseList1(listNode));
    }
}
