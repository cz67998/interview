package com.wangzhou.leecode;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/7/14
 * Time:14:39
 * Blog:https://blog.csdn.net/qq_38522268
 **/
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        dummy1.next = head;
        ListNode pre = dummy1, current = head, node = dummy2;
        int index = 1;
        while (current != null) {
            if (index % 2 == 0) {
                ListNode node1 = new ListNode(current.val);
                node.next = node1;
                node = node.next;
                current = current.next;
                pre.next = current;
            } else {
                pre = current;
                current = current.next;
            }
            index++;
        }
        pre.next=dummy2.next;
        return head;
    }
    public static void main(String[] args){
        Solution328 solution328=new Solution328();
        System.out.println(solution328.oddEvenList(LinkNodeUtil.createLinkList(new int[]{1,2,3,4,5}, 5)));

    }
}
