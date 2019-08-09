package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:10:34
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution19 {
    //滑动窗口O(N)
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p=dummy,q=head;
        for (int i = 0; i < n; i++) {
            q=q.next;
        }
        while (q!=null){
            p=p.next;
            q=q.next;
        }
        p.next=p.next.next;
        return dummy.next;
    }
    //遍历 2O(N)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        if (count == n) {
            return dummy.next.next;
        }
        if (count < n) {
            return null;
        } else {
            ListNode cur = head;
            for (int i = 0; i < count - n - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution19 solution19 = new Solution19();
        System.out.println(solution19.removeNthFromEnd1(
                LinkNodeUtil.createLinkList(new int[]{1, 2}, 2), 2));
    }
}
