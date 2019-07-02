package com.wangzhou.niuke;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/1
 * Time:16:15
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1=(p1==null?pHead2:p1.next);
            p2=(p2==null?pHead1:p2.next);
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(0);
        ListNode pHead1 = new ListNode(1);
        pHead1.next = common;
        ListNode pHead2 = new ListNode(2);
        ListNode node = new ListNode(3);
        ListNode node1 = new ListNode(4);
        pHead2.next=node;
        pHead2.next.next=node1;
//        pHead2.next.next = common;
        Solution36 solution36 = new Solution36();
        System.out.println(solution36.FindFirstCommonNode(pHead1, pHead2));
    }

}
