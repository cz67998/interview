package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:11:25
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        int n = k % count;
        if (n == 0) return head;
        return reverse(head, n);
    }

    private ListNode reverse(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy, q = head, pre = dummy, pre1 = dummy;
        for (int i = 0; i < n; i++) {
            q = q.next;
            pre = pre.next;
        }
        while (q != null) {
            q = q.next;
            p = p.next;
            pre = pre.next;
            pre1 = pre1.next;
        }

        ListNode next = p.next;
        pre1.next = null;
        pre.next = dummy.next;
        return next;
    }

    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        System.out.println(solution61.rotateRight(LinkNodeUtil.createLinkList(new int[]{1, 2, 3, 4}, 1), 1));
    }
}
