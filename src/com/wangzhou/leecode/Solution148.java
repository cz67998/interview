package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/15
 * Time:9:31
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution148 {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return separate(head, count);
    }

    private ListNode separate(ListNode head, int count) {
        while (count <= 1) return head;
        ListNode dymmy = new ListNode(-1);
        dymmy.next = head;
        ListNode right = head, pre = dymmy;
        int leftNum = count / 2, rightNum = count - count / 2;
        for (int i = 0; i < leftNum; i++) {
            pre = right;
            right = right.next;
        }
        pre.next = null;
        return merge(separate(dymmy.next, leftNum), separate(right, rightNum));
    }

    private ListNode merge(ListNode separate, ListNode separate1) {
        if (separate == null) return separate1;
        if (separate1 == null) return separate;
        ListNode head;
        if(separate.val<=separate1.val){
            head=separate;
            separate.next=merge(separate.next,separate1);
        }else {
            head=separate1;
            separate1.next=merge(separate,separate1.next );
        }
        return head;
    }

    public static void main(String[] args) {
        Solution148 solution148 = new Solution148();
        System.out.println(solution148.sortList(LinkNodeUtil.createLinkList(
                new int[]{4, 2, 1, 3}, 4)));
    }

    public ListNode InsertsortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode current = head;
        while (current != null) {
            ListNode node = dummy, next = current.next;
            while (node.next != null && node.next.val < current.val) {
                node = node.next;
            }
            current.next = node.next;
            node.next = current;
            current = next;
        }
        return dummy.next;
    }
}
